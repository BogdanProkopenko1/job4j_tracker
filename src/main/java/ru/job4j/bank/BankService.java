package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {

    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.put(user, new ArrayList<Account>());
    }
    /**
     * Метод по паспорту находит пользователя и добавляет в список аккаунтов новый
     * @param passport для верификации пользователя
     * @param account новый счет пользлвателя
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }
    /**
     *
     * @param passport идентефикатор пользователя
     * @return возврашает User с passport идентичным введенному идентефикатору
     */
    public User findByPassport(String passport) {
        User rsl = null;
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                rsl = user;
                break;
            }
        }
        return rsl;
    }
    /**
     *
     * @param passport идентефикатор пользователя
     * @param requisite идентефикатор счета пользователя
     * Метод принимает passport, через метод findByPassport извлекаает пользователя
     * по извлеченному пользователю возвращается коллекция с account
     * @return возврашяет аккаунт с реквизитами идентичными введенным
     */
    public Account findByRequisite(String passport, String requisite) {
        Account rsl = null;
        if (users.get(findByPassport(passport)) != null) {
            for (Account account : users.get(findByPassport(passport))) {
                if (account.getRequisite().equals(requisite)) {
                    rsl = account;
                    break;
                }
            }
        }
        return rsl;
    }
    /**
     * Метод принимает пасспорт и реквизиты получателя и отправителя
     * Нахоодит из аккаунты и переводит сумму amount получателю, снимая со счета отправителя
     * @param srcPassport пасспорт отправителя
     * @param srcRequisite счет отправителя
     * @param destPassport пасспорт получателя
     * @param destRequisite счет получателя
     * @param amount сумма перевода
     * @return возвращает осуществлен перевож или нет
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Account accountSrc = findByRequisite(srcPassport, srcRequisite);
        Account accountDest = findByRequisite(destPassport, destRequisite);
        boolean rtn = false;
        if (accountDest != null && accountSrc != null && amount <= accountSrc.getBalance()) {
                accountDest.setBalance(accountDest.getBalance() + amount);
                rtn = true;
        }
        return rtn;
    }
}