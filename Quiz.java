import java.util.*;

public class Quiz {
    static Scanner scanner = new Scanner(System.in);
    static List<Question> questions = new ArrayList<>();
    static List<String> userScores = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Welcome to QuizMaster AI");
        System.out.print("Login as (1) Admin or (2) User: ");
        int role = scanner.nextInt();
        scanner.nextLine(); // consume newline

        if (role == 1) {
            adminPanel();
        } else {
            userPanel();
        }
    }

    public static void adminPanel() {
        System.out.print("Enter admin password: ");
        String password = scanner.nextLine();
        if (!password.equals("admin123")) {
            System.out.println("❌ Incorrect password. Access denied.");
            return;
        }
        while (true) {
            System.out.println("\nAdmin Menu:");
            System.out.println("1. View Scores");
            System.out.println("2. Add Question");
            System.out.println("3. Edit Question");
            System.out.println("4. Delete Question");
            System.out.println("5. Exit Admin Panel");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("User Scores:");
                    for (String s : userScores) System.out.println(s);
                    break;
                case 2:
                    System.out.print("Enter question: ");
                    String question = scanner.nextLine();
                    String[] options = new String[4];
                    for (int i = 0; i < 4; i++) {
                        System.out.print("Option " + (char)('a' + i) + ": ");
                        options[i] = scanner.nextLine();
                    }
                    System.out.print("Enter correct option (1-4): ");
                    int correct = scanner.nextInt();
                    scanner.nextLine();
                    questions.add(new Question(question, options, correct));
                    System.out.println("✅ Question added.");
                    break;
                case 3:
                    System.out.print("Enter question number to edit (1 to " + questions.size() + "): ");
                    int editIndex = scanner.nextInt() - 1;
                    scanner.nextLine();
                    if (editIndex >= 0 && editIndex < questions.size()) {
                        Question q = questions.get(editIndex);
                        System.out.println("Editing: " + q.questionText);
                        System.out.print("New question text (leave blank to keep): ");
                        String newText = scanner.nextLine();
                        if (!newText.isEmpty()) q.questionText = newText;
                        for (int i = 0; i < 4; i++) {
                            System.out.print("New option " + (char)('a' + i) + " (leave blank to keep): ");
                            String opt = scanner.nextLine();
                            if (!opt.isEmpty()) q.options[i] = opt;
                        }
                        System.out.print("New correct option (1-4, 0 to keep): ");
                        int newCorrect = scanner.nextInt();
                        scanner.nextLine();
                        if (newCorrect >= 1 && newCorrect <= 4) q.correctOption = newCorrect;
                        System.out.println("✅ Question updated.");
                    } else {
                        System.out.println("Invalid question number.");
                    }
                    break;
                case 4:
                    System.out.print("Enter question number to delete (1 to " + questions.size() + "): ");
                    int deleteIndex = scanner.nextInt() - 1;
                    scanner.nextLine();
                    if (deleteIndex >= 0 && deleteIndex < questions.size()) {
                        questions.remove(deleteIndex);
                        System.out.println("🗑️ Question deleted.");
                    } else {
                        System.out.println("Invalid question number.");
                    }
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    public static void userPanel() {
        questions.clear();

        // Java basics and general knowledge
        questions.add(new Question("Which keyword is used to define a class in Java?",
                new String[]{"class", "interface", "extends", "package"}, 1));
        questions.add(new Question("Which method is the entry point for a Java application?",
                new String[]{"start()", "main()", "run()", "init()"}, 2));
        questions.add(new Question("Which symbol is used to end a statement in Java?",
                new String[]{":", ".", ",", ";"}, 4));
        questions.add(new Question("Which of these is not a Java keyword?",
                new String[]{"static", "Boolean", "void", "private"}, 2));
        questions.add(new Question("What is the capital of France?",
                new String[]{"Berlin", "Madrid", "Paris", "Rome"}, 3));
        questions.add(new Question("Who wrote 'Romeo and Juliet'?",
                new String[]{"Shakespeare", "Wordsworth", "Keats", "Milton"}, 1));
        questions.add(new Question("What is 5 + 7?",
                new String[]{"10", "11", "12", "13"}, 3));
        questions.add(new Question("What language is used for Android Development?",
                new String[]{"Python", "Kotlin", "Swift", "C++"}, 2));
        questions.add(new Question("Who is known as the father of computers?",
                new String[]{"Alan Turing", "Charles Babbage", "Einstein", "Elon Musk"}, 2));
        questions.add(new Question("Which metal is liquid at room temperature?",
                new String[]{"Mercury", "Iron", "Copper", "Aluminum"}, 1));
        questions.add(new Question("What is the tallest mountain in the world?",
                new String[]{"K2", "Kangchenjunga", "Mount Everest", "Lhotse"}, 3));
        questions.add(new Question("In which year did World War II end?",
                new String[]{"1940", "1945", "1939", "1950"}, 2));
        questions.add(new Question("What is the boiling point of water?",
                new String[]{"90°C", "80°C", "100°C", "120°C"}, 3));
        questions.add(new Question("Which element is essential for respiration?",
                new String[]{"Hydrogen", "Oxygen", "Carbon", "Nitrogen"}, 2));
        questions.add(new Question("How many continents are there?",
                new String[]{"5", "6", "7", "8"}, 3));
        questions.add(new Question("Which is the longest river in the world?",
                new String[]{"Amazon", "Nile", "Yangtze", "Mississippi"}, 2));
        questions.add(new Question("Which planet has rings around it?",
                new String[]{"Earth", "Mars", "Saturn", "Venus"}, 3));
        questions.add(new Question("Which is the largest mammal?",
                new String[]{"Elephant", "Blue Whale", "Giraffe", "Polar Bear"}, 2));
        questions.add(new Question("Which country is known as the Land of the Rising Sun?",
                new String[]{"China", "Korea", "Japan", "Thailand"}, 3));
        questions.add(new Question("What is the hardest natural substance?",
                new String[]{"Gold", "Iron", "Diamond", "Platinum"}, 3));
        questions.add(new Question("Which invention is attributed to Alexander Graham Bell?",
                new String[]{"Light Bulb", "Telephone", "Airplane", "Television"}, 2));
        questions.add(new Question("Which country has the largest population as of 2025?",
                new String[]{"India", "China", "USA", "Indonesia"}, 1));
        questions.add(new Question("Which gas do humans need to breathe?",
                new String[]{"Carbon Dioxide", "Oxygen", "Nitrogen", "Hydrogen"}, 2));
        questions.add(new Question("How many planets are officially recognized in our solar system as of 2025?",
                new String[]{"7", "8", "9", "10"}, 2));
        questions.add(new Question("Which vitamin is produced when sunlight hits the skin?",
                new String[]{"Vitamin A", "Vitamin B", "Vitamin C", "Vitamin D"}, 4));
        questions.add(new Question("Which sport is associated with Wimbledon?",
                new String[]{"Cricket", "Football", "Tennis", "Hockey"}, 3));
        questions.add(new Question("Which bird is known for its colorful feathers and dance?",
                new String[]{"Sparrow", "Eagle", "Peacock", "Owl"}, 3));
        questions.add(new Question("How many hours are there in two days?",
                new String[]{"24", "36", "48", "72"}, 3));
        questions.add(new Question("Which animal is known as the king of the jungle?",
                new String[]{"Tiger", "Elephant", "Lion", "Leopard"}, 3));
        questions.add(new Question("Which shape has three sides?",
                new String[]{"Circle", "Square", "Triangle", "Rectangle"}, 3));

        Collections.shuffle(questions);
        while (questions.size() > 30) {
            questions.remove(questions.size() - 1);
        }

        System.out.print("Enter your name: ");
        String username = scanner.nextLine();

        int score = 0;
        long startTime = System.currentTimeMillis();
        List<Question> wrongQuestions = new ArrayList<>();
        List<Character> userAnswers = new ArrayList<>();

        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            System.out.println("-------------------------------");
            System.out.println("Progress: " + (i + 1) + "/" + questions.size());
            q.displayQuestion(i);

            long questionStart = System.currentTimeMillis();
            System.out.print("Your answer (a-d): ");
            char userAnswerChar = scanner.next().toLowerCase().charAt(0);
            long questionEnd = System.currentTimeMillis();
            long timeTaken = (questionEnd - questionStart) / 1000;
            System.out.println("⏱️ Time taken for this question: " + timeTaken + " seconds");

            int userAnswer = userAnswerChar - 'a' + 1;

            if (q.isCorrect(userAnswer)) {
                System.out.println("✅ Correct!\n");
                score++;
            } else {
                System.out.println("❌ Wrong! Correct answer: " + (char)('a' + q.correctOption - 1) + ". " + q.options[q.correctOption - 1] + "\n");
                wrongQuestions.add(q);
                userAnswers.add(userAnswerChar);
            }
        }

        long endTime = System.currentTimeMillis();
        long duration = (endTime - startTime) / 1000;

        userScores.add(username + " - Score: " + score + "/" + questions.size() + ", Time: " + duration + "s");
        System.out.println("===============================");
        System.out.println("🎯 Quiz Over!");
        System.out.println("Your Score: " + score + "/" + questions.size());
        System.out.println("🕒 Total Time Taken: " + duration + " seconds");

        if (!wrongQuestions.isEmpty()) {
            System.out.println("\nReview your incorrect answers:");
            for (int i = 0; i < wrongQuestions.size(); i++) {
                Question q = wrongQuestions.get(i);
                char userAns = userAnswers.get(i);
                System.out.println("- Q: " + q.questionText);
                System.out.println("  Your answer: " + userAns + ". " + q.options[userAns - 'a']);
                System.out.println("  Correct answer: " + (char)('a' + q.correctOption - 1) + ". " + q.options[q.correctOption - 1]);
                System.out.println();
            }
        }

        if (score == questions.size()) {
            System.out.println("🌟 Incredible! You got a perfect score! You're a true quiz master!");
        } else if (score >= questions.size() * 0.8) {
            System.out.println("👏 Great job! You have excellent general knowledge!");
        } else if (score >= questions.size() * 0.5) {
            System.out.println("👍 Good effort! Keep learning and improving!");
        } else {
            System.out.println("💪 Don't give up! Practice makes perfect. You'll do better next time!");
        }
    }
}

// Question class inside same file
class Question {
    String questionText;
    String[] options;
    int correctOption;

    public Question(String questionText, String[] options, int correctOption) {
        this.questionText = questionText;
        this.options = options;
        this.correctOption = correctOption;
    }

    public boolean isCorrect(int userAnswer) {
        return userAnswer == correctOption;
    }

    public void displayQuestion(int index) {
        System.out.println("Q" + (index + 1) + ": " + questionText);
        char optionLabel = 'a';
        for (int i = 0; i < options.length; i++) {
            System.out.println(optionLabel + ". " + options[i]);
            optionLabel++;
        }
    }
}
