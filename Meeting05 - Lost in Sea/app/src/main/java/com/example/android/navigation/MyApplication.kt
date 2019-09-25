package com.example.android.navigation

import android.app.Application


class MyApplication: Application() {
    data class Scene(
        val title: String,
        val body: String,
        val actions: List<String>
    )

    companion object{
        val MAIN_MENU = "Main Menu"
        val TRY_AGAIN = "Try Again"
        val CONTINUE = "Continue"

        val scenes: List<Scene> = listOf(

            // 1
            Scene(
                    "Intro",
                    "My name Arthur. " +
                            "I was born on February 29, 19XX. " +
                            "I was born with a uniqueness where I was always lucky. " +
                            "At the age of 24, I won the door prize for a vacation to Hawaii for 7 days. " +
                            "Plus the cost for eating and lodging is covered. ",
                    actions = listOf(
                            "Use ticket and go sailing",
                            "Give to other people",
                            "Sell the ticket",
                            "Ignore the ticket"
                    )
            ),

            //2
            Scene(
                    "Shipwreckage",
                    "One week later," +
                            "I go sail to Hawaii. But, on the way to Hawaii." +
                            "The ship I was boarded suddenly sank and cause myself to be stranded on an empty island. " +
                            "I was shocked and had to accept the fact that only myself survived. ",
                    actions = listOf(
                            "Calm down",
                            "Panic",
                            "",
                            ""
                            )
            ),

            //3
            Scene(
                    "Charity Ending: Donors",
                    "It's good if this ticket is donated to people who can't afford it. ",
                    actions = listOf(
                            "Main menu",
                            "Try again",
                            "",
                            ""
                    )
            ),

            //4
            Scene(
                    "Pesky Ending: Pesky Ticket",
                    "Finally the ticket was sold at a pretty decent price. " +
                            "However, the ticket I sold brought disaster to the buyer. ",
                    actions = listOf(
                            "Main menu",
                            "Try again",
                            "",
                            ""
                    )
            ),

            //5
            Scene(
                    "Lucky Ending: You are Lucky",
                    "One week later, " +
                            "there was an accident in which the shipwreck was caused by the ship crashed by chunks of ice." +
                            "Luckily I did not take the cruise, because I've been there several times. ",
                    actions = listOf(
                            "Main menu",
                            "Try again",
                            "",
                            ""
                    )
            ),

            //6
            Scene(
                    "Calm Down Self",
                    "Finally, I can calm myself. ",
                    actions = listOf(
                            "Start gather item",
                            "",
                            "",
                            ""
                    )
            ),

            //7
            Scene(
                    "Worst Ending: Suicide",
                    "I decided to end my life, because it was too much suffering for me to endure alone. ",
                    actions = listOf(
                            "Main menu",
                            "Try again",
                            "",
                            ""
                    )
            ),

            //8
            Scene(
                    "Gathering Item",
                    "I must to survive in this island no matter whatever. " +
                            "First, i must to gather some item",
                    actions = listOf(
                            "Gather materials",
                            "Gather food",
                            "",
                            ""
                    )
            ),

            //9
            Scene(
                    "Gather Materials",
                    "I decide to gather some materials, and I get knife and plank. ",
                    actions = listOf(
                            "Continue gathering",
                            "",
                            "",
                            ""
                    )
            ),

            //10
            Scene(
                    "Gather Food",
                    "I decide to gather food around. ",
                    actions = listOf(
                            "Collect food",
                            "",
                            "",
                            ""
                    )
            ),

            //11
            Scene(
                    "Sorting Food",
                    "After collecting some food," +
                            "I get fish, coconut, unique red mushroom. " +
                            "I must to sort the food that are safe to eat. ",
                    actions = listOf(
                            "Eat fish and coconut",
                            "Eat all the food",
                            "",
                            ""
                    )
            ),

            //12
            Scene(
                    "Continue Gather Item",
                    "I gonna continue gather some item around this island. ",
                    actions = listOf(
                            "Gather materials",
                            "Gather food",
                            "",
                            ""
                    )
            ),

            //13
            Scene(
                    " Worst Ending: Poisoned",
                    "I'm to hungry, " +
                            "so I eat all the food and I don't know that one of my food contain deadly poison. ",
                    actions = listOf(
                            "Main menu",
                            "Try Again",
                            "",
                            ""
                    )
            ),

            //14
            Scene(
                    "Gather Materials",
                    "I decide to gather some materials, and I get rope, long stick, and tree trunks. ",
                    actions = listOf(
                            "Stop gathering",
                            "",
                            "",
                            ""
                    )
            ),

            //15
            Scene(
                    "Eat Food",
                    "After collecting some food," +
                            "I get rabbit, cicada, seaweed, mysterious colorful frog. " +
                            "I must to sort the food that are safe to eat. ",
                    actions = listOf(
                            "Eat rabbit, cicada, seaweed",
                            "Eat all the food",
                            "",
                            ""
                    )
            ),

            //16
            Scene(
                    "Build Boat",
                    "After the materials completely collected, " +
                            "I build small boat and go away from this island. ",
                    actions = listOf(
                            "Continue",
                            "",
                            "",
                            ""
                    )
            ),

            //17
            Scene(
                    "Wait Rescue Team",
                    "After the item collected, " +
                            "I build house and wait the rescue team. ",
                    actions = listOf(
                            "Wait hopelessly",
                            "Wait hopefully",
                            "",
                            ""
                    )
            ),

            //18
            Scene(
                    " Best Ending: Home Sweet Home",
                    "The ship finished on time, " +
                            "so I can go to my home. ",
                    actions = listOf(
                            "Main menu",
                            "Try Again",
                            "",
                            ""
                    )
            ),

            //19
            Scene(
                    " Best Ending: You are Safe",
                    "Finally the rescue team come to save me, " +
                            "and I can rest after going through this suffer. ",
                    actions = listOf(
                            "Main menu",
                            "Try Again",
                            "",
                            ""
                    )
            ),

            //20
            Scene(
                    "Another Ending: Your Second Home",
                    "The rescue team never come to save me, " +
                            "and none of the ships passed this island. ",
                    actions = listOf(
                            "Main menu",
                            "Try Again",
                            "",
                            ""
                    )
            )
        )

        var charityEnding = false
        var peskyEnding = false
        var luckyEnding = false
        var worstEnding1 = false
        var worstEnding2 = false
        var bestEnding1 = false
        var bestEnding2 = false
        var anotherEnding = false

        lateinit var currentDisplayEnding: Scene
    }
}