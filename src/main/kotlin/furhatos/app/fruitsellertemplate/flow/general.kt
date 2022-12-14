package furhatos.app.fruitsellertemplate.flow

import furhatos.flow.kotlin.*
import furhatos.records.User
import furhatos.util.*


val Idle: State = state {

    init {
        furhat.setVoice(Language.ENGLISH_US, Gender.MALE)
        if (users.count > 0) {
            furhat.attend(users.random)
            goto(Start)
        }
    }

    onEntry {
        furhat.attendNobody()
    }

    onUserEnter {
        furhat.attend(it)
        goto(Start)
    }
}

val Interaction: State = state {

    onUserLeave(instant = true) {
        if (users.count > 0) {
            if (it == users.current) {
                furhat.attend(users.other)
                goto(Start)
            } else {
                furhat.glance(it)
            }
        } else {
            goto(Idle)
        }
    }

    onUserEnter() {
        val c :User = users.current
        furhat.glance(it)
        furhat.attend(it)
        furhat.say("I will help you later")
        furhat.attend(c)
        reentry()
    }

}