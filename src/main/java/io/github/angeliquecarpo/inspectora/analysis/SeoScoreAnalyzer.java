package io.github.angeliquecarpo.inspectora.analysis;

public class SeoScoreAnalyzer {

        public int calculateScore(String contentStatus, String h1Status, String altStatus, String metaDescriptionStatus) {

            int score = 0;

            switch (contentStatus) {
                case "OK":
                    score += 40;
                    break;

                case "THIN CONTENT":
                    score += 30;
                    break;

                case "VERY THIN":
                    score += 15;
                    break;

                case "EMPTY":
                    score += 0;
                    break;
            }
            switch (h1Status) {
                case "OK":
                    score += 20;
                    break;

                case "MULTIPLE":
                    score += 10;
                    break;

                case "MISSING":
                    score += 0;
                    break;
            }

            switch (altStatus) {
                case "OK":
                case "NO IMAGES":
                    score += 20;
                    break;

                case "MISSING":
                    score += 0;
                    break;
            }

            switch (metaDescriptionStatus) {
                case "OK":
                    score += 20;
                    break;

                case "EMPTY":
                    score += 10;
                    break;

                case "MISSING":
                    score += 0;
                    break;
            }

            return score;
            }
        }
