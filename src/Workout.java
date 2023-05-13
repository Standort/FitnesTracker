public class Workout {
    private int workoutID;
    private String name;
    private float cloariesPerMinute;
    
    public Workout(int workoutID, String name, float cloariesPerMinute) {
        this.workoutID = workoutID;
        this.name = name;
        this.cloariesPerMinute = cloariesPerMinute;
    }
    
    public int getWorkoutID() {
        return workoutID;
    }
    
    public void setWorkoutID(int workoutID) {
        this.workoutID = workoutID;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public void setCaloriesPerMinute(float cloariesPerMinute) {
        this.cloariesPerMinute = cloariesPerMinute;
    }
    public float getCaloriesPerMinute() {
        return cloariesPerMinute;
    }
}
