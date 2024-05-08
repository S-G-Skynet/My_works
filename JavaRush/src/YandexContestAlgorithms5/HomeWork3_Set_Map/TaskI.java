package YandexContestAlgorithms5.HomeWork3_Set_Map;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskI {
    public static void main(String[] args) {
        LinkedHashSet<Command> commands = new LinkedHashSet<>();
        LinkedHashSet<Player> allPlayers = new LinkedHashSet<>();
        HashMap<Integer, Player> goals = new HashMap<>();
        boolean isFirstFoal = false;
        String s;
        StringBuilder result = new StringBuilder();
        int minMinute = 100;
        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
            int score1 = 0;
            int score2 = 0;
            String footballCommand1 = " ";
            String footballCommand2 = " ";
            while ((s = br.readLine()) != null) {
                if (s.startsWith("\"")) {
                    isFirstFoal = false;
                    String regex = "(.+) - (.+) (\\d+):(\\d+)";
                    Pattern pattern = Pattern.compile(regex);
                    Matcher matcher = pattern.matcher(s);
                    if (matcher.find()) {
                        String name1 = matcher.group(1);
                        String name2 = matcher.group(2);
                        footballCommand1 = name1;
                        footballCommand2 = name2;
                        score1 = Integer.parseInt(matcher.group(3));
                        score2 = Integer.parseInt(matcher.group(4));
                        Command command1 = new Command(name1, score1);
                        Command command2 = new Command(name2, score2);
                        if (!commands.contains(command1)) {
                            commands.add(command1);
                        } else {
                            Command command = findCommand(command1, commands);
                            command.setGoals(score1);
                            command.addMatch();
                        }
                        if (!commands.contains(command2)) {
                            commands.add(command2);
                        } else {
                            Command command = findCommand(command2, commands);
                            command.setGoals(score2);
                            command.addMatch();
                        }
                    }
                } else if (s.endsWith("'") && score1 != 0) {
                    String regex = "(.+) (\\d+)'";
                    Pattern pattern = Pattern.compile(regex);
                    Matcher matcher = pattern.matcher(s);
                    if (matcher.find()) {
                        String playerName = matcher.group(1);
                        int minute = Integer.parseInt(matcher.group(2));
                        Command command = findCommandByName(footballCommand1, commands);
                        Player player = new Player(playerName);
                        if (player.command == null)
                            player.setCommand(command);
                        allPlayers.add(player);
                        if (command.getPlayers() == null || !command.getPlayers().contains(player)) {
                            player.addMatch(command);
                            player.setGoal(minute);
                            command.setPlayer(player);
                            goals.put(minute, player);
                        } else {
                            Player player1 = findPlayer(player, command.getPlayers());
                            player1.setGoal(minute);
                            goals.put(minute, player1);
                        }
                        if (minute < minMinute)
                            minMinute = minute;
                    }
                    score1--;
                } else if (s.endsWith("'") && score2 != 0) {
                    String regex = "(.+) (\\d+)'";
                    Pattern pattern = Pattern.compile(regex);
                    Matcher matcher = pattern.matcher(s);
                    if (matcher.find()) {
                        String playerName = matcher.group(1);
                        int minute = Integer.parseInt(matcher.group(2));
                        Command command = findCommandByName(footballCommand2, commands);
                        Player player = new Player(playerName);
                        if (player.command == null)
                            player.setCommand(command);
                        allPlayers.add(player);
                        if (command.getPlayers() == null || !command.getPlayers().contains(player)) {
                            player.addMatch(command);
                            player.setGoal(minute);
                            command.setPlayer(player);
                            goals.put(minute, player);
                        } else {
                            Player player1 = findPlayer(player, command.getPlayers());
                            player1.setGoal(minute);
                            goals.put(minute, player1);
                        }
                        if (minute < minMinute)
                            minMinute = minute;
                    }
                    score2--;
                }
                if(score1 == 0 && score2 == 0) {
                    if (goals.containsKey(minMinute) && !isFirstFoal) {
                        Player player = goals.get(minMinute);
                        player.setScoreOpens();
                        player.command.scoreOpens++;
                        minMinute = 100;
                        isFirstFoal = true;
                        goals.clear();
                    }
                }
                if (s.startsWith("Total goals for")) {
                    String regex = "Total goals for *(.*)";
                    Pattern pattern = Pattern.compile(regex);
                    Matcher matcher = pattern.matcher(s);
                    if (matcher.find()) {
                        Command command = findCommandByName(matcher.group(1), commands);
                        if (commands.contains(command)) {
                            int totalGoals = command.getTotalGoals();
                            result.append(totalGoals).append("\n");
                        } else {
                            result.append(0).append("\n");
                        }
                    }
                } else if (s.startsWith("Total goals by")) {
                    String regex = "Total goals by *(.*)";
                    Pattern pattern = Pattern.compile(regex);
                    Matcher matcher = pattern.matcher(s);
                    if (matcher.find()) {
                        Player player = findPlayerByName(matcher.group(1), allPlayers);
                        if (allPlayers.contains(player)) {
                            int totalGoals = player.getTotalGoals();
                            result.append(totalGoals).append("\n");
                        } else {
                            result.append(0).append("\n");
                        }
                    }
                } else if (s.startsWith("Mean goals per game for")) {
                    String regex = "Mean goals per game for *(.*)";
                    Pattern pattern = Pattern.compile(regex);
                    Matcher matcher = pattern.matcher(s);
                    if (matcher.find()) {
                        Command command = findCommandByName(matcher.group(1), commands);
                        if (commands.contains(command)) {
                            double meanGoals = command.getMeanGoals();
                            result.append(meanGoals).append("\n");
                        } else {
                            result.append(0.0).append("\n");
                        }
                    }
                } else if (s.startsWith("Mean goals per game by")) {
                    String regex = "Mean goals per game by *(.*)";
                    Pattern pattern = Pattern.compile(regex);
                    Matcher matcher = pattern.matcher(s);
                    if (matcher.find()) {
                        Player player = findPlayerByName(matcher.group(1), allPlayers);
                        if (allPlayers.contains(player)) {
                            double meanGoals = player.getMeanGoals();
                            result.append(meanGoals).append("\n");
                        } else {
                            result.append(0.0).append("\n");
                        }
                    }
                } else if (s.startsWith("Goals on minute")) {
                    String regex = "Goals on minute (\\d+) by (.+)";
                    Pattern pattern = Pattern.compile(regex);
                    Matcher matcher = pattern.matcher(s);
                    if (matcher.find()) {
                        Player player = findPlayerByName(matcher.group(2), allPlayers);
                        if (player != null) {
                            int minute = Integer.parseInt(matcher.group(1));
                            int goalsOnMinute = player.getGoalsOnMinute(minute);
                            result.append(goalsOnMinute).append("\n");
                        }
                        else {
                            result.append(0).append("\n");
                        }
                    }
                } else if (s.startsWith("Goals on first")) {
                    String regex = "Goals on first (\\d+) minutes by (.+)";
                    Pattern pattern = Pattern.compile(regex);
                    Matcher matcher = pattern.matcher(s);
                    if (matcher.find()) {
                        Player player = findPlayerByName(matcher.group(2), allPlayers);
                        if (player != null) {
                            int sum = 0;
                            int minute = Integer.parseInt(matcher.group(1));
                            for (var entry : player.getHashGoalsOnMinute().entrySet()) {
                                if (entry.getKey() <= minute) {
                                    sum += entry.getValue();
                                }
                            }
                            result.append(sum).append("\n");
                        }
                        else {
                            result.append(0).append("\n");
                        }
                    }
                } else if (s.startsWith("Goals on last")) {
                    String regex = "Goals on last (\\d+) minutes by (.+)";
                    Pattern pattern = Pattern.compile(regex);
                    Matcher matcher = pattern.matcher(s);
                    if (matcher.find()) {
                        Player player = findPlayerByName(matcher.group(2), allPlayers);
                        if (player != null) {
                            int sum = 0;
                            int minute = 91 - Integer.parseInt(matcher.group(1));
                            for (var entry : player.getHashGoalsOnMinute().entrySet()) {
                                if (entry.getKey() >= minute) {
                                    sum += entry.getValue();
                                }
                            }
                            result.append(sum).append("\n");
                        }
                        else {
                            result.append(0).append("\n");
                        }
                    }
                } else if (s.startsWith("Score opens by")) {
                    String regex = "Score opens by *(.*)";
                    Pattern pattern = Pattern.compile(regex);
                    Matcher matcher = pattern.matcher(s);
                    if (matcher.find()) {
                        String name = matcher.group(1);
                        Command command = findCommandByName(name, commands);
                        Player player = findPlayerByName(name, allPlayers);
                        if (command != null) {
                            int scoreOpens = command.getScoreOpens();
                            result.append(scoreOpens).append("\n");
                        } else if (player != null) {
                            int scoreOpens = player.getScoreOpens();
                            result.append(scoreOpens).append("\n");
                        }
                        else {
                            result.append(0).append("\n");
                        }
                    }
                }
            }
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"))) {

            bw.write(result.toString());
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }

    public static Command findCommandByName(String name, HashSet<Command> set) {
        Command command = new Command(name, 1);
        if (set.contains(command)) {
            for (Command obj : set) {
                if (obj.equals(command))
                    return obj;
            }
        }
        return null;
    }

    public static Command findCommand(Command command, HashSet<Command> set) {
        if (set.contains(command)) {
            for (Command obj : set) {
                if (obj.equals(command))
                    return obj;
            }
        }
        return null;
    }

    public static Player findPlayerByName(String name, HashSet<Player> set) {
        Player player = new Player(name);
        if (set.contains(player)) {
            for (Player obj : set) {
                if (obj.equals(player))
                    return obj;
            }
        }
        return null;
    }

    public static Player findPlayer(Player player, HashSet<Player> set) {
        if (set.contains(player)) {
            for (Player obj : set) {
                if (obj.equals(player))
                    return obj;
            }
        }
        return null;
    }

    static double myRound(double x, int precision) {
        return ((int) (x * Math.pow(10.0, precision)) / Math.pow(10.0, precision));
    }

    static class Command {
        String name;
        double matches;
        int totalGoals;
        int scoreOpens;
        double meanGoals;
        HashSet<Player> players = new HashSet<>();

        public Command(String name, int currentGoals) {
            this.matches++;
            this.name = name;
            this.totalGoals += currentGoals;
            this.meanGoals = totalGoals / matches;
        }

        public void setGoals(int goals) {
            this.matches++;
            this.totalGoals += goals;
            this.meanGoals = totalGoals / matches;
        }

        public HashSet<Player> getPlayers() {
            return players;
        }


        public void addMatch() {
            for (var player : players) {
                player.matches++;
                player.meanGoals = player.totalGoals / player.matches;
            }
        }

        public void setScoreOpens(int goals) {
            if (goals > 0 && matches <= scoreOpens) {
                scoreOpens++;
            }
        }

        public double getMatches() {
            return matches;
        }

        public int getScoreOpens() {
            return scoreOpens;
        }

        public int getTotalGoals() {
            return totalGoals;
        }

        public double getMeanGoals() {
            return meanGoals;
        }

        public void setPlayer(Player player) {
            players.add(player);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Command command = (Command) o;
            return name.equals(command.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }

    static class Player {
        String name;
        double matches;
        int totalGoals;
        int scoreOpens;
        double meanGoals;
        Command command;
        HashMap<Integer, Integer> goalsOnMinute = new HashMap<>();

        public Player(String name) {
            this.name = name;
        }

        public void setGoal(int minute) {
            totalGoals++;
            if (goalsOnMinute == null || !goalsOnMinute.containsKey(minute)) {
                goalsOnMinute.put(minute, 1);
            } else {
                int goals = goalsOnMinute.get(minute) + 1;
                goalsOnMinute.put(minute, goals);
            }
            meanGoals = totalGoals / matches;
        }

        public void setMatches() {
            this.matches++;
        }

        public void setCommand(Command command) {
            this.command = command;
        }

        public void     setScoreOpens() {
            this.scoreOpens++;
        }

        public int getScoreOpens() {
            return scoreOpens;
        }

        public int getTotalGoals() {
            return totalGoals;
        }

        public void addMatch(Command command) {
            this.matches = command.getMatches();
        }

        public int getGoalsOnMinute(int minute) {
            return goalsOnMinute.getOrDefault(minute, 0);
        }

        public HashMap<Integer, Integer> getHashGoalsOnMinute() {
            return goalsOnMinute;
        }

        public double getMeanGoals() {
            return meanGoals;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Player player = (Player) o;
            return name.equals(player.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }
}
