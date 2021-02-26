package ru.job4j.bank;

import java.util.*;

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
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            User adding = user.get();
            List<Account> accounts = users.get(adding);
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

    public Optional<User> findByPassport(String passport) {
        return users.keySet().stream()
                .filter(s -> s.getPassport().equals(passport))
                .findFirst();
    }

    /**
     *
     * @param passport идентефикатор пользователя
     * @param requisite идентефикатор счета пользователя
     * Метод принимает passport, через метод findByPassport извлекаает пользователя
     * по извлеченному пользователю возвращается коллекция с account
     * @return возврашяет аккаунт с реквизитами идентичными введенным
     */

    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            return users.get(user.get()).stream()
                    .filter(s -> s.getRequisite().equals(requisite))
                    .findFirst();
        } else {
            return Optional.empty();
        }
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
        Optional<Account> optionalSrc = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> optionalDest = findByRequisite(destPassport, destRequisite);
        boolean rtn = false;
        if (optionalDest.isPresent() && optionalSrc.isPresent()) {
            Account accountSrc = optionalSrc.get();
            Account accountDest = optionalDest.get();
            if (accountSrc.getBalance() >= amount) {
                accountDest.setBalance(accountDest.getBalance() + amount);
                accountSrc.setBalance(accountSrc.getBalance() - amount);
                rtn = true;
            }
        }
        return rtn;
    }
}