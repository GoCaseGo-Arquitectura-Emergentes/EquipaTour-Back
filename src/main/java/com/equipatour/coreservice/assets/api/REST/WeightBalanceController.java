package com.equipatour.coreservice.assets.api.REST;

import com.equipatour.coreservice.assets.api.transformation.CreateScaleCommandFromRequestDtoAssembler;
import com.equipatour.coreservice.assets.api.transformation.UpdateWeightBalanceCommandFromRequestDtoAssembler;
import com.equipatour.coreservice.assets.domain.model.WeightBalance;
import com.equipatour.coreservice.assets.domain.queries.GetWeightBalanceByIdQuery;
import com.equipatour.coreservice.assets.domain.services.WeightBalanceCommandService;
import com.equipatour.coreservice.assets.mapper.IOTMapper;
import com.equipatour.coreservice.assets.resources.requests.CreateScaleRequestDto;
import com.equipatour.coreservice.assets.resources.requests.WeightBalanceRequestDto;
import com.equipatour.coreservice.assets.resources.summaries.WeightBalanceSummaryDto;
import com.equipatour.coreservice.shared.constants.HeaderConstants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.equipatour.coreservice.shared.messages.ConfigurationMessages.WEIGHT_BALANCE_UPDATED;

@RestController
@RequestMapping("/api/v1/weight-balances")
@Tag(name="Weight Sensors Controller")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class WeightBalanceController {

    private final WeightBalanceCommandService weightBalanceCommandService;
    private final IOTMapper iotMapper;

    @Autowired
    public WeightBalanceController(WeightBalanceCommandService weightBalanceCommandService,
                                   IOTMapper iotMapper) {
        this.weightBalanceCommandService = weightBalanceCommandService;
        this.iotMapper = iotMapper;
    }

    @GetMapping("/{balanceId}")
    @Operation(summary = "Obtener Peso", description = "Permite ver peso.")
    public WeightBalanceSummaryDto getTemperature(@Parameter @PathVariable("balanceId") Long balanceId) {
        WeightBalance balance = weightBalanceCommandService.handle(new GetWeightBalanceByIdQuery(balanceId));
        return iotMapper.balanceToSummaryDto(balance);
    }

    @PutMapping("/update-weight/{balanceId}")
    @Operation(summary = "Actualizar Peso", description = "Permite actualizar el peso de la balanza.")
    public WeightBalanceSummaryDto updateWeight(@Parameter @PathVariable("balanceId") Long balanceId,
                                                @RequestBody @Valid WeightBalanceRequestDto requestDto,
                                                HttpServletResponse response) {
        WeightBalance balance =
                weightBalanceCommandService.handle(UpdateWeightBalanceCommandFromRequestDtoAssembler.toCommandFromDto(balanceId, requestDto));
        response.setHeader(HeaderConstants.MESSAGES, WEIGHT_BALANCE_UPDATED);
        return iotMapper.balanceToSummaryDto(balance);
    }
    @PostMapping("create-balance")
    @Operation(summary = "Crear balanza", description = "Permite crear una la balanza.")
    public WeightBalanceSummaryDto createBalance(@RequestBody @Valid CreateScaleRequestDto requestDto,
                                                 HttpServletResponse response) {
        WeightBalance balance = weightBalanceCommandService.handle(CreateScaleCommandFromRequestDtoAssembler.toCommandFromDto(requestDto));
        response.setHeader(HeaderConstants.MESSAGES, WEIGHT_BALANCE_UPDATED);
        return iotMapper.balanceToSummaryDto(balance);
    }
}
