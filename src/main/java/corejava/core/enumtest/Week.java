package corejava.core.enumtest;

public enum Week {

    MONDAY(0, "星期一"){
        @Override
        public Week getNextDay() {
            return TUESDAY;
        }
    },
    TUESDAY(1, "星期二"){
        @Override
        public Week getNextDay() {
            return WEDNESDAY;
        }
    },
    WEDNESDAY(2, "星期三"){
        @Override
        public Week getNextDay() {
            return THURSDAY;
        }
    },
    THURSDAY(3, "星期四"){
        @Override
        public Week getNextDay() {
            return FRIDAY;
        }
    },
    FRIDAY(4, "星期五"){
        @Override
        public Week getNextDay() {
            return TUESDAY;
        }
    },
    SATURDAY(5, "星期六"){
        @Override
        public Week getNextDay() {
            return SUNDAY;
        }
    },
    SUNDAY(6, "星期日"){
        @Override
        public Week getNextDay() {
            return MONDAY;
        }
    };

    private int num;
    private String weekDay;

    Week(int num, String weekDay) {
        this.num = num;
        this.weekDay = weekDay;
    }

    public abstract Week getNextDay();

    public int getNum() {
        return num;
    }

    public String getWeekDay() {
        return weekDay;
    }


    @Override
    public String toString() {
        return this.num + " " + this.weekDay;
    }


}
