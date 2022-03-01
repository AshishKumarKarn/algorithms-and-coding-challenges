package com.karn.hashcode.practice.qualificationround2022;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int contributorsSize = sc.nextInt();
        int projectsSize = sc.nextInt();
        Contributor[] contributors = new Contributor[contributorsSize];
        for (int i = 0; i < contributorsSize; i++) {
            contributors[i] = new Contributor();
            contributors[i].cName = sc.next();
            contributors[i].skills = sc.nextByte();
            contributors[i].skillList = new Skill[contributors[i].skills];
            for (int j = 0; j < contributors[i].skills; j++) {
                Skill skill = new Skill();
                skill.sName = sc.next();
                skill.level = sc.nextByte();
                contributors[i].skillList[j] = skill;
            }
        }
        Project[] projects = new Project[projectsSize];
        for (int i = 0; i < projectsSize; i++) {
            Project project = new Project();
            project.pName = sc.next();
            project.pDays = sc.nextInt();
            project.score = sc.nextInt();
            project.bestBeforeDays = sc.nextInt();
            project.noOfRoles = sc.nextByte();
            project.skillsRequired = new Skill[project.noOfRoles];
            for (byte j = 0; j < project.noOfRoles; j++) {
                Skill skill = new Skill();
                skill.sName = sc.next();
                skill.level = sc.nextByte();
                project.skillsRequired[j] = skill;
            }
            projects[i] = project;
        }

        System.out.println(Arrays.toString(contributors));
        System.out.println(Arrays.toString(projects));


    }

    //byte short
    static class Contributor {
        private String cName;
        private byte skills;
        private Skill[] skillList;

        @Override
        public String toString() {
            return "Contributor{" +
                    "cName='" + cName + '\'' +
                    ", skills=" + skills +
                    ", skillList=" + Arrays.toString(skillList) +
                    '}';
        }
    }

    static class Skill {
        private String sName;
        private byte level;

        @Override
        public String toString() {
            return "Skill{" +
                    "sName='" + sName + '\'' +
                    ", level=" + level +
                    '}';
        }
    }

    static class Project {
        private String pName;
        private int pDays;
        private int score;
        private int bestBeforeDays;
        private byte noOfRoles;
        private Skill[] skillsRequired;// = new Skill[noOfRoles];

        @Override
        public String toString() {
            return "Project{" +
                    "pName='" + pName + '\'' +
                    ", pDays=" + pDays +
                    ", score=" + score +
                    ", bestBeforeDays=" + bestBeforeDays +
                    ", noOfRoles=" + noOfRoles +
                    ", skillsRequired=" + Arrays.toString(skillsRequired) +
                    '}';
        }
    }
}
