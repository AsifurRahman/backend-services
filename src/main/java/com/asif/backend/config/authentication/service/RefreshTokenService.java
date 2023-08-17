package com.asif.backend.config.authentication.service;

import com.asif.backend.config.authentication.model.RefreshToken;
import com.asif.backend.payload.request.RefreshTokenRequest;
import com.asif.backend.payload.response.RefreshTokenResponse;

public interface RefreshTokenService {
    RefreshToken createRefreshToken(Long userId);

    RefreshToken verifyRefreshTokenExpiration(RefreshToken refreshToken);

    RefreshTokenResponse tokenRefresh(RefreshTokenRequest request);
}
