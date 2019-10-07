package mvc

import grails.validation.Validateable

class CalculatorController {

    def calc(CalculatorModel calculatorModel) {
        double result = (calculatorModel.en + calculatorModel.exam) / 2
        // Inverstigate 'calculatorModel.errors' to find out which field is concerned.
        // Refer to 'feature/validation' branch

        /* Imperative Validierung - START */
        if (1 > calculatorModel.en || calculatorModel.en > 6){
            calculatorModel.result = "en input is wrong"
        } else if (1 > calculatorModel.exam || calculatorModel.exam > 6) {
            calculatorModel.result = "exam input is wrong"
        } else {
            calculatorModel.result = result
        }
        /* Imperative Validierung - END */
        render view: "CalculatorOutput", model: [model: calculatorModel]
    }
}

// Für eine Deklarative Validierung, muss das Validateable Interface implementiert werden
class CalculatorModel implements Validateable {

    double en
    double exam
    String result

    /* Deklarative Validierung - START */
    /* Wurde jetzt hier noch nicht angewendet */
    static constraints = {
        en min:1d, max: 6d, scale: 1
        exam min:1d, max: 6d, scale: 1
        result nullable: true
    }
    /* Deklarative Validierung - END */

}
