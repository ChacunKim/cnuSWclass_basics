package org.prgrms.kdt.voucher;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

//메모리에서 관리되는 repository
@Repository
@Profile("dev") //ApplicationContext 에 @Bean, @Profile로도 정의할 수 있음.
public class JDBCVoucherRepository implements VoucherRepository {

    //메모리에서 관리: 해시맵 사용. thread-safety를 위해 Concurrency를 사용
    private final Map<UUID, Voucher> storage = new ConcurrentHashMap<>();

    @Override
    public Optional<Voucher> findById(UUID voucherId) {
        return Optional.ofNullable(storage.get(voucherId));
    }

    @Override
    public Voucher insert(Voucher voucher) {
        storage.put(voucher.getVoucherId(), voucher);
        return voucher;
    }
}
