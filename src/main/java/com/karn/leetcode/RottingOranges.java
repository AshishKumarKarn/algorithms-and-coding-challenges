package com.karn.leetcode;

import java.util.HashSet;
import java.util.Set;

public class RottingOranges {

    public int orangesRotting(int[][] grid) {
        //1. check if un-reachable (4-D neighbour all 0) 1 present return -1;
        //2. while each bucket is either 0 or 2 && add all 2's in a set
        // do -> increment 2's (contained in set)
        // neighbour to 1 and increment counter
        // return counter
        if (grid.length == 1 && grid[0].length == 1) {
            if (grid[0][0] == 0) {
                return 0;
            }
            if (grid[0][0] == 1) {
                return -1;
            }
            if (grid[0][0] == 2) {
                return 0;
            }
        }
        int counter = -1;
        if (checkIfUnReachableBucket(grid))
            return -1;
        while (!allZeroOrTwoInGrid(grid) && !set.isEmpty()) {
            counter++;
            incrementNeighbours(grid);
        }
        if ((!set.isEmpty() || !zeroSet.isEmpty())) {
            counter++;
        }

        return counter == 0 && !oneSet.isEmpty() ? -1 : counter;
    }

    private void incrementNeighbours(int[][] grid) {
        for (String entry : set) {
            String[] s = entry.split("_");
            int i = Integer.parseInt(s[0]);
            int j = Integer.parseInt(s[1]);
            //base case
            if (grid.length == 1 && grid[i].length == 1) {
                //nothing
            } else if (grid.length == 1) {
                if (j > 0 && j < grid[i].length - 1) {
                    if (grid[i][j + 1] == 1) {
                        grid[i][j + 1] = 2;
                    }
                    if (grid[i][j - 1] == 1) {
                        grid[i][j - 1] = 2;
                    }
                } else if (j == 0) {
                    if (grid[i][j + 1] == 1) {
                        grid[i][j + 1] = 2;
                    }
                } else if (j == grid[i].length - 1) {
                    if (grid[i][j - 1] == 1) {
                        grid[i][j - 1] = 2;
                    }
                }
            } else if (grid[i].length == 1) {
                if (i > 0 && i < grid.length - 1) {
                    if (grid[i + 1][j] == 1) {
                        grid[i + 1][j] = 2;
                    }
                    if (grid[i - 1][j] == 1) {
                        grid[i - 1][j] = 2;
                    }
                } else if (i == 0) {
                    if (grid[i + 1][j] == 1) {
                        grid[i + 1][j] = 2;
                    }
                } else if (i == grid.length - 1) {
                    if (grid[i - 1][j] == 1) {
                        grid[i - 1][j] = 2;
                    }
                }
            } else if (i == 0 && j == 0) {
                if (grid[i][j + 1] == 1) {
                    grid[i][j + 1] = 2;
                }
                if (grid[i + 1][j] == 1) {
                    grid[i + 1][j] = 2;
                }
            } else if (i == grid.length - 1 && j == grid[i].length - 1) {
                if (grid[i - 1][j] == 1) {
                    grid[i - 1][j] = 2;
                }
                if (grid[i][j - 1] == 1) {
                    grid[i][j - 1] = 2;
                }
            } else if (i == 0 && j == grid[i].length - 1) {
                if (grid[i + 1][j] == 1) {
                    grid[i + 1][j] = 2;
                }
                if (grid[i][j - 1] == 1) {
                    grid[i][j - 1] = 2;
                }
            } else if (j == 0 && i == grid.length - 1) {
                if (grid[i - 1][j] == 1) {
                    grid[i - 1][j] = 2;
                }
                if (grid[i][j + 1] == 1) {
                    grid[i][j + 1] = 2;
                }
            } else if (i == 0) {
                if (grid[i][j + 1] == 1) {
                    grid[i][j + 1] = 2;
                }
                if (grid[i + 1][j] == 1) {
                    grid[i + 1][j] = 2;
                }
                if (grid[i][j - 1] == 1) {
                    grid[i][j - 1] = 2;
                }
            } else if (j == 0) {
                if (grid[i - 1][j] == 1) {
                    grid[i - 1][j] = 2;
                }
                if (grid[i][j + 1] == 1) {
                    grid[i][j + 1] = 2;
                }
                if (grid[i + 1][j] == 1) {
                    grid[i + 1][j] = 2;
                }
            } else if (i == grid.length - 1) {
                if (grid[i - 1][j] == 1) {
                    grid[i - 1][j] = 2;
                }
                if (grid[i][j + 1] == 1) {
                    grid[i][j + 1] = 2;
                }
                if (grid[i][j - 1] == 1) {
                    grid[i][j - 1] = 2;
                }
            } else if (j == grid[i].length - 1) {
                if (grid[i - 1][j] == 1) {
                    grid[i - 1][j] = 2;
                }
                if (grid[i + 1][j] == 1) {
                    grid[i + 1][j] = 2;
                }
                if (grid[i][j - 1] == 1) {
                    grid[i][j - 1] = 2;
                }
            } else {
                if (grid[i - 1][j] == 1) {
                    grid[i - 1][j] = 2;
                }
                if (grid[i][j + 1] == 1) {
                    grid[i][j + 1] = 2;
                }
                if (grid[i + 1][j] == 1) {
                    grid[i + 1][j] = 2;
                }
                if (grid[i][j - 1] == 1) {
                    grid[i][j - 1] = 2;
                }
            }
        }
    }

    private Set<String> set = new HashSet<>();
    private Set<String> zeroSet = new HashSet<>();
    private Set<String> oneSet = new HashSet<>();


    private boolean allZeroOrTwoInGrid(int[][] grid) {
        Set<String> newSet = new HashSet<>();
        boolean result = true;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    oneSet.add(i + "_" + j);
                    result = false;
                }
                if (grid[i][j] == 2) {
                    newSet.add(i + "_" + j);
                }
                if (grid[i][j] == 0) {
                    zeroSet.add(i + "_" + j);
                }
            }
        }
        newSet.removeAll(set);
        set = newSet;
        return result;
    }

    private boolean checkIfUnReachableBucket(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    //base case
                    if (grid.length == 1 && grid[i].length == 1) {
                        return true;
                    } else if (grid.length == 1) {
                        if (j == 0) {
                            if ((grid[i][j + 1] == 0)) {
                                return true;
                            }
                        } else if (j == grid[i].length - 1) {
                            if ((grid[i][j - 1] == 0)) {
                                return true;
                            }
                        } else {
                            if ((grid[i][j + 1] == 0) && (grid[i][j - 1] == 0)) {
                                return true;
                            }
                        }

                    } else if (grid[i].length == 1) {
                        if (i == 0) {
                            if ((grid[i + 1][j] == 0)) {
                                return true;
                            }
                        } else if (i == grid.length - 1) {
                            if ((grid[i - 1][j] == 0)) {
                                return true;
                            }
                        } else {
                            if ((grid[i - 1][j] == 0) && (grid[i + 1][j] == 0)) {
                                return true;
                            }
                        }
                    }

                    //corner case
                    else if (i == 0 && j == 0) {
                        if ((grid[i + 1][j] == 0) && (grid[i][j + 1] == 0)) {
                            return true;
                        }
                    } else if (i == 0 && j == grid[i].length - 1) {
                        if ((grid[i + 1][j] == 0) && (grid[i][j - 1] == 0)) {
                            return true;
                        }
                    } else if (j == 0 && i == grid.length - 1) {
                        if ((grid[i - 1][j] == 0) && (grid[i][j + 1] == 0)) {
                            return true;
                        }
                    } else if (i == grid.length - 1 && j == grid[i].length - 1) {
                        if ((grid[i - 1][j] == 0) && (grid[i][j - 1] == 0)) {
                            return true;
                        }
                    }
                    //edge case
                    else if (i == 0) {
                        if (grid[i + 1][j] == 0 && grid[i][j - 1] == 0 && grid[i][j + 1] == 0) {
                            return true;
                        }
                    } else if (j == 0) {
                        if (grid[i + 1][j] == 0 && grid[i][j + 1] == 0 && grid[i - 1][j] == 0) {
                            return true;
                        }
                    } else if (i == grid.length - 1) {
                        if (grid[i][j - 1] == 0 && grid[i][j + 1] == 0 && grid[i - 1][j] == 0) {
                            return true;
                        }
                    } else if (j == grid[i].length - 1) {
                        if (grid[i][j - 1] == 0 && grid[i + 1][j] == 0 && grid[i - 1][j] == 0) {
                            return true;
                        }
                    } else {
                        if (grid[i][j - 1] == 0 && grid[i][j + 1] == 0 && grid[i + 1][j] == 0 && grid[i - 1][j] == 0) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
