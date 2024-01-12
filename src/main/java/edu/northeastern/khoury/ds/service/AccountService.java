package edu.northeastern.khoury.ds.service;

import edu.northeastern.khoury.ds.domain.dto.account.SignUpRequest;;
import edu.northeastern.khoury.ds.domain.dto.account.SignUpResponse;
import edu.northeastern.khoury.ds.domain.dto.account.SignInResponse;
import edu.northeastern.khoury.ds.domain.model.Account;
import edu.northeastern.khoury.ds.exception.ResourceNotFoundException;
import edu.northeastern.khoury.ds.mapper.AccountMapper;
import edu.northeastern.khoury.ds.repository.AccountRepository;
import edu.northeastern.khoury.ds.security.AuthenticationTokenProvider;
import edu.northeastern.khoury.ds.domain.dto.account.SignInRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountMapper accountMapper;
    private final AccountRepository accountRepository;
    private final AuthenticationManager authenticationManager;
    private final AuthenticationTokenProvider authenticationTokenProvider;

    public SignUpResponse signUp(SignUpRequest request) {
        final Account mappedAccount = accountMapper.mapToEntity(request);
        final Account savedAccount = accountRepository.save(mappedAccount);
        return accountMapper.mapToResponse(savedAccount);
    }

    public SignInResponse signIn(SignInRequest signInRequest) {
        final UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                signInRequest.username(),
                signInRequest.password()
        );

        final Authentication authentication = authenticationManager.authenticate(authenticationToken);
        final String accessToken = authenticationTokenProvider.generate(authentication);
        return new SignInResponse(accessToken);
    }

    public Account findByUsername(String username) {
        return accountRepository.findById(username).orElseThrow(ResourceNotFoundException::new);
    }

    public Account findByUsernameLoadCreditCards(String username) {
        return accountRepository.findByUsername(username).orElseThrow(ResourceNotFoundException::new);
    }

    public Account save(Account account) {
        return accountRepository.save(account);
    }
//
//    public List<MenuItem> findFavoriteMenuItems(String username) {
//        final List<FavoriteMenuItem> favoriteMenuItems = favoriteMenuItemService.findByUsername(username);
//        return favoriteMenuItems.stream().map(FavoriteMenuItem::getMenuItem).collect(Collectors.toList());
//    }
//
//    public List<MenuItem> deleteFavoriteMenuItem(String username, Integer menuItemId) {
//        final FavoriteMenuItemId favoriteMenuItemId = new FavoriteMenuItemId();
//        favoriteMenuItemId.setMenuItemId(menuItemId);
//        favoriteMenuItemId.setUsername(username);
//
//        favoriteMenuItemService.deleteById(favoriteMenuItemId);
//        return favoriteMenuItemService.findByUsername(username).stream()
//                .map(FavoriteMenuItem::getMenuItem)
//                .collect(Collectors.toList());
//    }
//
//    public AddFavoriteMenuItemResponse addFavoriteMenuItem(String username, Integer menuItemId) {
//        final MenuItem menuItem = menuItemService.findById(menuItemId);
//        final Account account = findById(username);
//
//        final FavoriteMenuItem savedFavoriteMenuItem = favoriteMenuItemService.save(account, menuItem);
//        return new AddFavoriteMenuItemResponse(username, menuItemId, savedFavoriteMenuItem.getLikedAt());
//    }
}
