package ru.job4j.map;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double sum = 0;
        int count = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
                count++;
            }
        }
        return sum / count;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> averageScore = new ArrayList<>(pupils.size());
        for (Pupil pupil : pupils) {
            double sum = 0;
            int count = 0;
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
                count++;
            }
            averageScore.add(new Label(pupil.name(), sum / count));
        }
        return averageScore;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> subjectMap = new HashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                subjectMap.merge(subject.name(), subject.score(), Integer::sum);
            }
        }
        List<Label> averageScore = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : subjectMap.entrySet()) {
            averageScore.add(new Label(entry.getKey(), (double) entry.getValue() / pupils.size()));
        }
        return averageScore;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> bestPupil = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double sum = 0;
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
            }
            bestPupil.add(new Label(pupil.name(), sum));
        }
        bestPupil.sort(Comparator.reverseOrder());
        return bestPupil.get(0);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        List<Subject> subjectList = pupils.get(0).subjects();
        List<Label> bestSubject = new ArrayList<>();
        for (int i = 0; i < subjectList.size(); i++) {
            double sum = 0;
            for (Pupil pupil : pupils) {
                sum += pupil.subjects().get(i).score();
            }
            bestSubject.add(new Label(subjectList.get(i).name(), sum));
        }
        bestSubject.sort(Comparator.reverseOrder());
        return bestSubject.get(0);
    }
}
