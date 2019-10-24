package com.example.android.navigation

import android.app.Application
import timber.log.Timber

class Story: Application() {
    data class Question(
            val text: String,
            val answers: List<String>)

    // The first answer is the correct one.  We randomize the answers before showing the text.
    // All questions must have four answers.  We'd want these to contain references to string
    // resources so we could internationalize. (Or better yet, don't define the questions in code...)
    val questions: List<Question> = listOf(
            Question(text = "You awake in a dimly lit room. You have no recollection of what just happened. In the grip of your right arm" +
                    "lies a photo of yourself with a note that says = \"Find a way out\". There are 4 doors in front of you, colored Blue, Red, Yellow, and Green" +
                    "in that order. You know that there's at least one safe way out, but which one?",
                    answers = listOf("Blue door", "Red door", "Yellow door", "Green door")),
            Question(text = "What is the base class for layouts?",
                    answers = listOf("ViewGroup", "ViewSet", "ViewCollection", "ViewRoot")),
            Question(text = "What layout do you use for complex screens?",
                    answers = listOf("ConstraintLayout", "GridLayout", "LinearLayout", "FrameLayout")),
            Question(text = "What do you use to push structured data into a layout?",
                    answers = listOf("Data binding", "Data pushing", "Set text", "An OnClick method")),
            Question(text = "What method do you use to inflate layouts in fragments?",
                    answers = listOf("onCreateView()", "onActivityCreated()", "onCreateLayout()", "onInflateLayout()")),
            Question(text = "What's the build system for Android?",
                    answers = listOf("Gradle", "Graddle", "Grodle", "Groyle")),
            Question(text = "Which class do you use to create a vector drawable?",
                    answers = listOf("VectorDrawable", "AndroidVectorDrawable", "DrawableVector", "AndroidVector")),
            Question(text = "Which one of these is an Android navigation component?",
                    answers = listOf("NavController", "NavCentral", "NavMaster", "NavSwitcher")),
            Question(text = "Which XML element lets you register an activity with the launcher activity?",
                    answers = listOf("intent-filter", "app-registry", "launcher-registry", "app-launcher")),
            Question(text = "What do you use to mark a layout for data binding?",
                    answers = listOf("<layout>", "<binding>", "<data-binding>", "<dbinding>"))
    )
    var LOG_PREFIX = "[TIMBER LOGGING] : "

    var ON_CREATE_CALLED = LOG_PREFIX + "onCreate() Called!"
    var ON_START_CALLED = LOG_PREFIX + "onStart() Called!"
    var ON_RESUME_CALLED = LOG_PREFIX + "onResume() Called!"
    var ON_PAUSE_CALLED = LOG_PREFIX + "onPause() Called!"
    var ON_STOP_CALLED = LOG_PREFIX + "onStop() Called!"
    var ON_DESTROY_CALLED = LOG_PREFIX + "onDestroy() Called!"
    var ON_RESTART_CALLED = LOG_PREFIX + "onRestart() Called!"
    var ON_ATTACH_CALLED = LOG_PREFIX + "onAttach() Called!"
    var ON_DETACH_CALLED = LOG_PREFIX + "onDetach() Called!"
    var ON_CREATE_VIEW__CALLED = LOG_PREFIX + "onCreateView() Called!"
    var ON_DESTROY_VIEW__CALLED = LOG_PREFIX + "onDestroyView() Called!"
}

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())

}