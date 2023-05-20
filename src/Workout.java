public class Workout {
    private int workoutID;
    private String name;
    private float caloriesPerMinute;
    
    public Workout(int workoutID, String name, float caloriesPerMinute) {
        this.workoutID = workoutID;
        this.name = name;
        this.caloriesPerMinute = caloriesPerMinute;
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
        this.caloriesPerMinute = cloariesPerMinute;
    }
    public float getCaloriesPerMinute() {
        return caloriesPerMinute;
    }
}
