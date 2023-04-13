package sample11_bank;

import java.nio.channels.NonWritableChannelException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.LongToDoubleFunction;

public class BankingService {

	private BankingRepository repo = new BankingRepository();
	
	// 신규 계좌 개설하기 기능
	/* 사용자가 입력한 신규 계좌정보를 전달받아서 영속화계층을 저장시키고, 개설된 계좌정보를 반환한다.
	 * 반환타입: Account
	 * 메소드명: createAccount
	 * 매개변수: Account account
	 */
	public Account creatAccount(Account account) {
		
		// 전달받은 계좌정보에 계좌상태, 개설일시를 저장한다.
		account.setStatus("사용중");
		account.setCreateDate(new Date());
		
		// 영속화 계층에 계좌정보를 전달해서 저장시킨다.
		repo.insertAccount(account);
		
		return account;
	}
	
	
	// 전계좌 조회하기
	/*
	 * 예금주명을 전달받아서 해당 예금주명을 개설된 모든 계좌정보를 조회해서 반환한다.
	 * 반환타입: List<Account>
	 * 메소드명: getMyAllAccounts
	 * 매개변수: String name 
	 */
	public List<Account> getMyAllAccounts(String name) {
		List<Account> accounts = repo.getAccountsByName(name);
		return accounts; 
	}
	
	
	// 계좌상세정보 조회하기
	/*
	 * 계좌번호와 비밀번호를 전달받아서 반환한다.
	 * 반환타입: Account
	 * 메소드명: getAccountDetail
	 * 매개변수: int accNo
	 */
	public Account getAccountDetail(int accNo, int pwd) {
		Account account = repo.getAccountByNo(accNo);
		if (account == null) {
			return null;
		}
		
		if (account.getPassword() != pwd) {
			return null;
		}
		
		return account;
	}
	
	
	// 입금하기
	/*
	 * 계좌번호와 입금액을 전달받아서 현재 잔액을 증가시킨다.
	 * 반환타입: boolean
	 * 메소드명: deposit
	 * 매개변수: int no, long amount
	 */
	public boolean deposit(int accNo, long amount) {
		Account account = repo.getAccountByNo(accNo);  
		if (account == null) {
			return false;
		}
		
		long balance = account.getBalance() + amount;
		account.setBalance(balance);
		
		return true;
	}
	
	
	// 출금하기
	public boolean withdraw(int accNo, int pwd, long amount) {
		Account account = repo.getAccountByNo(accNo);
		if (account == null) {
			return false;
		}
		
		if (pwd != account.getPassword()) {
			System.out.println("비밀번호가 일치하지 않습니다.");
			return false;
		}
		
		if (account.getBalance() < amount) {
			System.out.println("출금가능한 잔액이 부족합니다.");
			return false;
		}
	
		long balance = account.getBalance() - amount;
		account.setBalance(balance);
		
		return true;
	}
	
	
	// 비밀번호 변경하기
	public boolean changePassword(int accNo, int prePwd, int newPwd) {
		Account account = repo.getAccountByNo(accNo);
		if (account == null) {
			return false;
		}
		
		if (prePwd != account.getPassword()) {
			return false;
		}
		
		account.setPassword(newPwd);
		return true;
	}
	
	
	// 해지하기 
	public Map<String, Object> expireAccount(int accNo, int password) {
		Map<String, Object> result = new HashMap<>();
		
		Account account = repo.getAccountByNo(accNo);
		if (account == null) {
			result.put("success", false);
			return result;
		}
		
		if (password != account.getPassword()) {
			result.put("success", false);
			return result;
		}
		
		int interest = (int)(account.getBalance()*account.getInterestRate());
		result.put("success", true);
		result.put("no", account.getNo());
		result.put("owner", account.getOwner());
		result.put("balance", account.getBalance());
		result.put("interest", interest);  // 이자
		result.put("amount", account.getBalance() + interest);  // 해지예상금액
		
		repo.deleteAccount(accNo);
		
		return result;
	}
}








