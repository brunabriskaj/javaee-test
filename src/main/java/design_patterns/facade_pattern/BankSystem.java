package design_patterns.facade_pattern;

import design_patterns.facade_pattern.subsystems.*;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *  BankSystem is a facade
 *  An EJB is a POJO that is annotated either stateless, stateful, or singleton.
 *  The BankSystem is a stateless session bean. => ( do not want this facade to maintain any kind of state )
 *  Here you can inject services.
 *  Since the BankSystem is an EJB, use a different annotation than the injector annotation. Use @EJB annotation to inject a service.
 */
@Stateless
public class BankSystem {

    @EJB
    private CreditRatingService creditRatingService;

    @EJB
    private RepaymentPayabilityService repaymentPayabilityService;

    @EJB
    private InternalBankPolicyService internalBankPolicyService;

    @EJB
    private TransferService transferService;

    @EJB
    private RepaymentService repaymentService;

    public boolean processLoanApplication(Customer customer, Double principle, Double income, Integer months) {

        boolean passes = creditRatingService.checkCustomerRating(customer);
        if (!passes) return false;

        boolean affordable = repaymentPayabilityService.calculatePayability(principle, income, months);
        if (!affordable) return false;

        boolean compliant = internalBankPolicyService.checkCompliance(customer);
        if (!compliant) return false;

        // Application successful, so transfer principle and set up repayment schedule
        transferService.makeTransfer(principle, customer);
        repaymentService.setUpPaymentSchedule(customer, principle, months);

        return true;
    }
}
