package com.coding.problem2;

import java.util.Objects;

/**
 * Java 17, not Lombok
 * Define a private class with properties:
 * Private final fields for age, name, and team.
 * * Canonical constructors for all fields.
 * * Getters for all fields.
 * * equals, hashCode, and toString for all fields.
 */

class EasyClass {

    static class HackathonDeveloper {
        private final int age;
        private final String name;
        private final String team;

        public HackathonDeveloper(String name, int age, String team) {
            if (age < 0) {
                throw new IllegalArgumentException("Age cannot be a negative number!");
            }
            this.age = age;
            this.name = name;
            this.team = team;
        }

        public int age() {
            return age;
        }

        public String name() {
            return name;
        }

        public String team() {
            return team;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            HackathonDeveloper that = (HackathonDeveloper) o;
            return age == that.age && Objects.equals(name, that.name) && Objects.equals(team, that.team);
        }

        @Override
        public int hashCode() {
            return Objects.hash(age, name, team);
        }

        @Override
        public String toString() {
            return "HackathonDeveloper{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    ", team='" + team + '\'' +
                    '}';
        }
    }
}
