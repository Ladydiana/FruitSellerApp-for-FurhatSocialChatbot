package furhatos.app.fruitsellertemplate

import furhatos.app.fruitsellertemplate.flow.*
import furhatos.skills.Skill
import furhatos.flow.kotlin.*

class FruitsellertemplateSkill : Skill() {
    override fun start() {

        Flow().run(Idle)
    }
}

fun main(args: Array<String>) {
    Skill.main(args)
}
