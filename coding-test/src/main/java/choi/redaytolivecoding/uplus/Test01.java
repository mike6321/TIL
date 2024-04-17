package choi.redaytolivecoding.uplus;

import java.util.*;

public class Test01 {

    public static void main(String[] args) {
        int num_teams = 3;
        String[] remote_tasks = {"development", "marketing", "hometask"};
        String[] office_tasks = {"recruitment", "education", "officetask"};
        String[] employees = {
                "1 development hometask",
                "1 recruitment marketing",
                "2 hometask",
                "2 development marketing hometask",
                "3 marketing",
                "3 officetask",
                "3 development"
        };
//        int num_teams = 2;
//        String[] remote_tasks = {"design"};
//        String[] office_tasks = {"building", "supervise"};
//        String[] employees = {"2 design", "1 supervise building design", "1 design", "2 design"};

        int[] result = solution(num_teams, remote_tasks, office_tasks, employees);
        System.out.println(Arrays.toString(result));
    }


    public static int[] solution(int num_teams, String[] remote_tasks, String[] office_tasks, String[] employees) {
        Set<String> remoteSet = new HashSet<>(Arrays.asList(remote_tasks));
        Set<String> officeSet = new HashSet<>(Arrays.asList(office_tasks));
        List<Integer> remoteWorkers = new ArrayList<>();
        Map<Integer, List<Integer>> teamMembers = new HashMap<>();

        // Initialize team members data structure for each team
        for (int i = 1; i <= num_teams; i++) {
            teamMembers.put(i, new ArrayList<>());
        }

        // Parse employee information
        for (int i = 0; i < employees.length; i++) {
            String[] parts = employees[i].split(" ", 2);
            int teamNumber = Integer.parseInt(parts[0]);
            String[] tasks = parts[1].split(" ");
            boolean canWorkRemote = true;

            // Check if the employee can work remotely by checking all tasks against officeSet
            for (String task : tasks) {
                if (officeSet.contains(task)) {
                    canWorkRemote = false;
                    break;
                }
            }

            // Track team members
            teamMembers.get(teamNumber).add(i + 1);

            // Check against remoteSet if all tasks are remote tasks
            if (canWorkRemote) {
                boolean allRemoteTasks = Arrays.stream(tasks).allMatch(remoteSet::contains);
                if (allRemoteTasks) {
                    remoteWorkers.add(i + 1);
                }
            }
        }

        // Ensure at least one team member goes to office
        List<Integer> finalRemoteWorkers = new ArrayList<>();
        for (int team = 1; team <= num_teams; team++) {
            List<Integer> members = teamMembers.get(team);
            boolean allRemote = new HashSet<>(remoteWorkers).containsAll(members);

            if (allRemote) {
                // The smallest employee number must go to office
                Collections.sort(members);
                int mustWorkFromOffice = members.get(0);
                members.remove(0); // Remove the office-going employee
                finalRemoteWorkers.addAll(members);
            } else {
                // Only add remote workers that are not needed in office
                for (int member : members) {
                    if (remoteWorkers.contains(member)) {
                        finalRemoteWorkers.add(member);
                    }
                }
            }
        }

        // Return result sorted
        Collections.sort(finalRemoteWorkers);
        return finalRemoteWorkers.stream().mapToInt(Integer::intValue).toArray();
    }

}
