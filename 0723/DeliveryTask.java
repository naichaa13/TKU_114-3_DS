public class DeliveryTask {
    private String taskId;
    private String destination;

    public DeliveryTask(String taskId, String destination) {
        this.taskId = taskId.trim();
        this.destination = destination.trim();
    }

    public String getTaskId() {
        return taskId;
    }

    public String getDestination() {
        return destination;
    }

    @Override
    public String toString() {
        return "任務代碼: " + taskId + " | 目的地: " + destination;
    }
}