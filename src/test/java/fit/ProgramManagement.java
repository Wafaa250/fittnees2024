package fit;

import java.util.ArrayList;
import java.util.List;

public class ProgramManagement {

    private List<Program> programs = new ArrayList<>();

    // Method to add a new program
    public String addProgram(Program program) {
        for (Program p : programs) {
            if (p.getId().equals(program.getId())) {
                return "Program ID already exists. Please choose a unique ID";
            }
        }
        if (program.getSessions() <= 0) {
            return "Missing data: Number of sessions cannot be zero";
        }
        programs.add(program);
        return "Program added successfully";
    }

    // Method to update an existing program
    public String updateProgram(String id, Program updatedProgram) {
        for (int i = 0; i < programs.size(); i++) {
            if (programs.get(i).getId().equals(id)) {
                programs.set(i, updatedProgram);
                return "Program updated successfully";
            }
        }
        return "Program not found";
    }

    // Method to remove a program
    public String removeProgram(String id) {
        for (Program p : programs) {
            if (p.getId().equals(id)) {
                programs.remove(p);
                return "Program removed successfully";
            }
        }
        return "Program not found";
    }

    // Method to list all programs (for testing purposes)
    public List<Program> listPrograms() {
        return programs;
    }

    // Inner class to represent a fitness program
    public static class Program {
        private String title;
        private String id;
        private String description;
        private String startDate;
        private String duration;
        private int sessions;
        private boolean isActive;

        // Constructor
        public Program(String title, String id, String description, String startDate, String duration, int sessions, boolean isActive) {
            this.title = title;
            this.id = id;
            this.description = description;
            this.startDate = startDate;
            this.duration = duration;
            this.sessions = sessions;
            this.isActive = isActive;
        }

        // Getters and Setters
        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getStartDate() {
            return startDate;
        }

        public void setStartDate(String startDate) {
            this.startDate = startDate;
        }

        public String getDuration() {
            return duration;
        }

        public void setDuration(String duration) {
            this.duration = duration;
        }

        public int getSessions() {
            return sessions;
        }

        public void setSessions(int sessions) {
            this.sessions = sessions;
        }

        public boolean isActive() {
            return isActive;
        }

        public void setActive(boolean active) {
            isActive = active;
        }

        @Override
        public String toString() {
            return "Program{" +
                    "title='" + title + '\'' +
                    ", id='" + id + '\'' +
                    ", description='" + description + '\'' +
                    ", startDate='" + startDate + '\'' +
                    ", duration='" + duration + '\'' +
                    ", sessions=" + sessions +
                    ", isActive=" + isActive +
                    '}';
        }
    }

    public static void main(String[] args) {
        ProgramManagement pm = new ProgramManagement();

        // Test cases
        Program program1 = new Program("Weight Loss Program", "12345", "Lose 10kg in 3 months", "2024/01/01", "3 months", 30, true);
        Program program2 = new Program("Cardio Program", "12346", "High-intensity workout", "2024/01/01", "3 months", 0, true);

        System.out.println(pm.addProgram(program1)); // Expected: Program added successfully
        System.out.println(pm.addProgram(program2)); // Expected: Missing data: Number of sessions cannot be zero
        System.out.println(pm.addProgram(program1)); // Expected: Program ID already exists. Please choose a unique ID

        Program updatedProgram = new Program("Advanced Weight Loss Program", "12345", "Lose 15kg in 3 months", "2024/01/01", "3 months", 45, true);
        System.out.println(pm.updateProgram("12345", updatedProgram)); // Expected: Program updated successfully
        System.out.println(pm.removeProgram("12345")); // Expected: Program removed successfully
    }
}
