package bgu.spl.net.impl.BGRS;

import bgu.spl.net.api.MessageEncoderDecoder;
import bgu.spl.net.impl.BGRS.commands.*;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class BGRSEncoderDecoder implements MessageEncoderDecoder<Command> {

    private byte[] bytes = new byte[1<<10];
    private int length = 0;
    private short opcodeNum  = -1;
    private short courseNum = -1;
    private String username;
    private String password;

    @Override
    public Command decodeNextByte(byte nextByte) {
        if (opcodeNum == -1) {
            bytes[length++] = nextByte;
            if (length ==2) {
                opcodeNum = bytesToShort(Arrays.copyOfRange(bytes, 0, 2));
                length = 0;
            }
            return null;
        }
        else {
            Command command = null;
            if (decodeByOpcode(nextByte)) {
                command = getCommandByOpcode();
                reset();
            }
            return command;
        }
    }

    private void reset() {
        opcodeNum = -1;
        length = 0;
        bytes = new byte[1<<10];
        username = null;
        password = null;
    }

    private Command getCommandByOpcode() {
        switch (opcodeNum) {
            case 1:
                return new AdminRegCommand(username, password);
            case 2:
                return new StudentRegCommand(username, password);
            case 3:
                return new LoginCommand(username, password);
            case 4:
                return new LogoutCommand();
            case 5:
                return new RegisterCommand(courseNum);
            case 6:
                return new CheckKdamCommand(courseNum);
            case 7:
                return new CourseStatCommand(courseNum);
            case 8:
                return new StudentStatCommand(username);
            case 9:
                return new IsRegisteredCommand(courseNum);
            case 10:
                return new UnregisterCommand(courseNum);
            case 11:
                return new MyCoursesCommand();
        }
        return null;
    }

    private boolean decodeByOpcode(byte nextByte) {
        switch (opcodeNum) {
            case 1:
            case 2:
            case 3:
                if (username == null)
                    decodeUsername(nextByte);
                else if (password == null)
                    decodePassword(nextByte);
                return username != null && password != null;
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                if (courseNum == -1)
                    decodeCourseNum(nextByte);
                return courseNum != -1;
            case 11:
        }
        return false;
    }

    private void decodeCourseNum(byte nextByte) {
        if (nextByte != '\0')
            pushByte(nextByte);
        else {
            courseNum =
            length = 0;
        }
    }

    private void decodePassword(byte nextByte) {
        if (nextByte != '\0')
            pushByte(nextByte);
        else {
            password = new String(bytes, 0, length, StandardCharsets.UTF_8);
            length = 0;
        }
    }

    private void pushByte(byte nextByte) {
       if (length >= bytes.length) {
           bytes = Arrays.copyOf(bytes, length *2);
       }
       bytes[length++] = nextByte;
    }

    private void decodeUsername(byte nextByte) {
        if (nextByte != '\0')
            pushByte(nextByte);
        else {
            username = new String(bytes, 0, length, StandardCharsets.UTF_8);
            length = 0;
        }
    }

    private short bytesToShort(byte[] copyOfRange) {
        ByteBuffer bb = ByteBuffer.allocate(2);
        bb.order(ByteOrder.LITTLE_ENDIAN);
        bb.put(copyOfRange[0]);
        bb.put(copyOfRange[1]);
        short shortVal = bb.getShort(0);
        return shortVal;
    }

    @Override
    public byte[] encode(Command message) {
        return new byte[0];
    }
}
