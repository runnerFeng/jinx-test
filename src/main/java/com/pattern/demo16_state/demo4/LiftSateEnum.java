package com.pattern.demo16_state.demo4;

/**
 * Desc:
 * Created by jinx on 2017/9/1.
 */
public enum LiftSateEnum implements LiftState {
    OPENING {
        @Override
        public void close(Lift lift) {
            lift.setState(CLOSING);
            System.out.println("电梯关闭了");
        }
    },
    RUNNING {
        @Override
        public void stop(Lift lift) {
            lift.setState(STOPPING);
            System.out.println("电梯停止了");
        }
    },
    CLOSING {
        @Override
        public void open(Lift lift) {
            lift.setState(OPENING);
            System.out.println("电梯打开了");
        }

        @Override
        public void run(Lift lift) {
            lift.setState(RUNNING);
            System.out.println("电梯运行了");
        }

        @Override
        public void stop(Lift lift) {
            lift.setState(STOPPING);
            System.out.println("电梯停止了");
        }
    },
    STOPPING {
        @Override
        public void open(Lift lift) {
            lift.setState(OPENING);
            System.out.println("电梯打开了");
        }

        @Override
        public void run(Lift lift) {
            lift.setState(RUNNING);
            System.out.println("电梯运行了");
        }
    }
}
