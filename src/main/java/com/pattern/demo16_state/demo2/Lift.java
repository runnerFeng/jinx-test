package com.pattern.demo16_state.demo2;

/**
 * Desc:站在方法的角度去检查状态，一个方法中只能执行特定状态下的行为
 * Created by jinx on 2017/8/31.
 */
public class Lift implements ILift {

    private int state;

    @Override
    public void setState(int state) {
        this.state = state;
    }

    @Override
    public void open() {
        switch (this.state) {
            case OPENING_STATE:
                break;
            case CLOSING_STATE:
                this.openWithoutLogic();
                this.setState(OPENING_STATE);
                break;
            case RUNNING_STATE:
                break;
            case STOPPING_STATE:
                this.openWithoutLogic();
                this.setState(OPENING_STATE);
                break;
        }
    }

    @Override
    public void close() {
        switch (this.state) {
            case OPENING_STATE:
                this.closeWithoutLogic();
                this.setState(CLOSING_STATE);
                break;
            case CLOSING_STATE:
                break;
            case RUNNING_STATE:
                break;
            case STOPPING_STATE:
                break;
        }
    }

    @Override
    public void run() {
        switch (this.state) {
            case OPENING_STATE:

                break;
            case CLOSING_STATE:
                this.runWithoutLogic();
                this.setState(RUNNING_STATE);
                break;
            case RUNNING_STATE:
                break;
            case STOPPING_STATE:
                this.runWithoutLogic();
                this.setState(RUNNING_STATE);
                break;
        }
    }

    @Override
    public void stop() {
        switch (this.state) {
            case OPENING_STATE:
                break;
            case CLOSING_STATE:
                this.stopWithoutLogic();
                this.setState(STOPPING_STATE);
                break;
            case RUNNING_STATE:
                this.stopWithoutLogic();
                this.setState(STOPPING_STATE);
                break;
            case STOPPING_STATE:
                break;
        }
    }

    private void closeWithoutLogic() {
        System.out.println("电梯门关闭");
    }

    private void runWithoutLogic() {
        System.out.println("电梯运行了");
    }

    private void openWithoutLogic() {
        System.out.println("电梯门打开");
    }

    private void stopWithoutLogic() {
        System.out.println("电梯停止");
    }
}
