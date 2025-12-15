package org.logesh.dto;

import lombok.Builder;
import lombok.Data;
import org.logesh.entity.Bid;
import org.logesh.entity.Buyer;

@Data
@Builder
public class CloseAuctionResponseDto {

    private boolean hasWinner;
    private Buyer buyer;
    private Bid winningBid;

    public static CloseAuctionResponseDto from(Bid bid) {
        return CloseAuctionResponseDto.builder()
                .winningBid(bid)
                .hasWinner(bid != null ? true : false)
                .buyer(bid != null ? bid.getBuyer() : null)
                .build();
    }

}
