package com.mab.hiltdemo.data.network


object EndPoints {
    const val GET_EMAIL_SIGN_UP = "SignUpByEmailWithMobile/Get"
    const val GET_EMAIL_VERIFICATION_CODE = "SendVerificationCode/Get"
    const val GET_SUB_CATEGORY = "SubCategory/Get"
    const val GET_SUBJECTS = "Subject/Get"
    const val GET_UPDATE_VIEWS = "UpdateTutorViews/Get"
    const val GET_TUTOR_SCHEDULE = "AvailableLessons/Get"
    const val GET_CART_ITEMS = "BasketLessons/Get"
    const val GET_DELETE_FROM_BUCKET = "DeleteLesson/Get"
    const val GET_ADD_SCHEDULE_TO_BUCKET = "AddLesson/Get"
    const val GET_COUNTRIES = "country"
    const val GET_TIME_ZONES = "TimeZone/Get"
    const val GET_ALL_COUNTRIES = "CountryAll"
    const val GET_TUTOR_LESSONS = "TutorBookedLessons/Get"
    const val GET_LESSON_INFO = "LessonButtons/Get"
    const val GET_CONFIRM_LESSON = "LessonConfirm/Get"
    const val GET_UPDATE_USER_INFO = "UpdateStudent/Get"
    const val GET_CART_COUNT = "BasketLessonsCount/Get"
    const val GET_UPCOMING_LESSONS = "UpComingLessons/Get"
    const val GET_START_PAYMENT = "AddTransaction/Get"
    const val GET_EMAIL_LOGIN = "SignInByEmailWithDetails/Get"
    const val GET_TUTOR_PROFILES = "ConsultantSearchByCountryId/Get"
    const val GET_TUTOR_PROFILE = "ConsultantSearch/Get"
    const val GET_CATEGORY = "CategoryByCountryId/Get"

    const val GET_BOOKED_LESSONS = "BookedLessons/Get"
    const val GET_SEND_CHAT_MSG = "AddChatMsg/Get"

    //phase 2
    const val GET_USER_EXIST = "AccountExist/Get"
    const val GET_SOCIAL_SSIGN_UP = "SignUpByEmailWithSocialMediaBtn/Get"
    const val GET_CHAT_LIST = "ChatMsgForStudent/Get"
    const val GET_MESSAGE_LIST = "ChatDetailsForStudent/Get"
    const val GET_TUTOR_CHAT_LIST = "ChatMsgForTutor/Get"
    const val GET_TUTOR_MESSAGE_LIST = "ChatDetailsForStudent/Get"
}