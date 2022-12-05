package furhatos.app.fruitsellertemplate.flow

import furhatos.app.fruitsellertemplate.nlu.FruitList
import furhatos.records.User


class FruitData (
        var fruits : FruitList = FruitList()
)

val User.order : FruitData
    get() = data.getOrPut(FruitData::class.qualifiedName, FruitData())

