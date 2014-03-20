CREATE SCHEMA projectDefinition;

CREATE TABLE projectDefinition.constraintDateType (
                constraintDateType_id IDENTITY NOT NULL,
                constraintDateType_label VARCHAR(255) NOT NULL,
				constraintDateType_languageCode VARCHAR(255),
                CONSTRAINT constraintDateType_id PRIMARY KEY (constraintDateType_id)
);


CREATE TABLE projectDefinition.meetingMedia (
                meetingMedia_id IDENTITY NOT NULL,
                meetingMedia_label VARCHAR(255) NOT NULL,
                CONSTRAINT meetingMedia_id PRIMARY KEY (meetingMedia_id)
);


CREATE TABLE projectDefinition.responsibility (
                responsibility_id IDENTITY NOT NULL,
                responsibility_mode VARCHAR(2),
                responsibility_label VARCHAR(255),
                CONSTRAINT responsibility_id PRIMARY KEY (responsibility_id)
);


CREATE TABLE projectDefinition.riskNature (
                riskNature_id IDENTITY NOT NULL,
                riskNature_label VARCHAR(255) NOT NULL,
                CONSTRAINT riskNature_id PRIMARY KEY (riskNature_id)
);


CREATE TABLE projectDefinition.frequency (
                frequency_id IDENTITY NOT NULL,
                frequency_label VARCHAR(255) NOT NULL,
                CONSTRAINT frequency_id PRIMARY KEY (frequency_id)
);


CREATE TABLE projectDefinition.recordCarrier (
                recordCarrier_id IDENTITY NOT NULL,
                recordCarrier_label VARCHAR(255) NOT NULL,
                CONSTRAINT recordCarrier_id PRIMARY KEY (recordCarrier_id)
);


CREATE TABLE projectDefinition.skill (
                skill_id IDENTITY NOT NULL,
                skill_label VARCHAR(255) NOT NULL,
                CONSTRAINT skill_id PRIMARY KEY (skill_id)
);


CREATE TABLE projectDefinition.allocationMode (
                allocationMode_id IDENTITY NOT NULL,
                allocationMode_label VARCHAR(255) NOT NULL,
                CONSTRAINT allocationMode_id PRIMARY KEY (allocationMode_id)
);


CREATE TABLE projectDefinition.resourceType (
                resourceType_id IDENTITY NOT NULL,
                resourceType_label VARCHAR(255) NOT NULL,
                CONSTRAINT resourceType_id PRIMARY KEY (resourceType_id)
);


CREATE TABLE projectDefinition.riskStrategy (
                riskStrategy_id IDENTITY NOT NULL,
                riskStrategy_label VARCHAR(255) NOT NULL,
                CONSTRAINT riskStrategy_id PRIMARY KEY (riskStrategy_id)
);


CREATE TABLE projectDefinition.trackingMethod (
                trackingMethod_id IDENTITY NOT NULL,
                trackingMethod_label VARCHAR(255) NOT NULL,
                CONSTRAINT trackingMethod_id PRIMARY KEY (trackingMethod_id)
);


CREATE TABLE projectDefinition.flexibility (
                flexibility_id IDENTITY NOT NULL,
                flexibility_code VARCHAR(2),
                flexibility_label VARCHAR(255),
                CONSTRAINT flexibility_id PRIMARY KEY (flexibility_id)
);


CREATE TABLE projectDefinition.level (
                level_id IDENTITY NOT NULL,
                level_label VARCHAR(255) NOT NULL,
                CONSTRAINT level_id PRIMARY KEY (level_id)
);


CREATE TABLE projectDefinition.user (
                user_id IDENTITY NOT NULL,
                user_name VARCHAR(255) NOT NULL,
                user_password VARCHAR(255) NOT NULL,
                project_idLastProject BIGINT,
                CONSTRAINT user_id PRIMARY KEY (user_id)
);


CREATE TABLE projectDefinition.project (
                project_id IDENTITY NOT NULL,
                project_label VARCHAR(255) NOT NULL,
				project_name VARCHAR(255),
				project_description CLOB,
				customer_name VARCHAR(255),
                user_projectManagerId BIGINT,
                CONSTRAINT project_id PRIMARY KEY (project_id)
);


CREATE TABLE projectDefinition.targetGroup (
                targetGroup_id IDENTITY NOT NULL,
                project_id BIGINT NOT NULL,
                targetGroup_code VARCHAR(255) NOT NULL,
                targetGroup_label VARCHAR(255) NOT NULL,
                CONSTRAINT targetGroup_pk PRIMARY KEY (targetGroup_id)
);


CREATE TABLE projectDefinition.element (
                element_id IDENTITY NOT NULL,
                project_id BIGINT NOT NULL,
                element_label VARCHAR(255) NOT NULL,
                element_description CLOB,
                element_isWorkpackage BOOLEAN,
                element_start TIMESTAMP,
                element_workload DECIMAL,
                element_duration DECIMAL,
                element_isContractual BOOLEAN,
                element_achievCriteria CLOB,
                element_delivDate TIMESTAMP,
                element_laborAmount DECIMAL,
                element_purchaseAmount DECIMAL,
                element_expenseAmount DECIMAL,
                element_rentAmount DECIMAL,
                element_subContrAmount DECIMAL,
                element_earlyStart TIMESTAMP,
                element_earlyFinish TIMESTAMP,
                element_lateStart TIMESTAMP,
                element_lateFinish TIMESTAMP,
                element_totalSlack DECIMAL,
                element_freeSlack DECIMAL,
                Parent_element_id BIGINT,
                element_rank INTEGER,
                CONSTRAINT element_pk PRIMARY KEY (element_id)
);


CREATE TABLE projectDefinition.place (
                place_id IDENTITY NOT NULL,
                project_id BIGINT NOT NULL,
                place_code VARCHAR(255),
                place_label VARCHAR(255),
                CONSTRAINT place_pk PRIMARY KEY (place_id)
);


CREATE TABLE projectDefinition.meeting (
                meeting_id IDENTITY NOT NULL,
                project_id BIGINT NOT NULL,
                meeting_code VARCHAR(255),
                meeting_label VARCHAR(255),
                frequency_id BIGINT,
                meetingMedia_id BIGINT,
                place_id BIGINT,
                CONSTRAINT meeting_pk PRIMARY KEY (meeting_id)
);


CREATE TABLE projectDefinition.activity (
                activity_id IDENTITY NOT NULL,
                project_id BIGINT NOT NULL,
                activity_label VARCHAR(255) NOT NULL,
                activity_description CLOB,
                activity_workload DECIMAL,
                activity_duration DECIMAL,
                activity_hypothesis CLOB,
                activity_calcNote CLOB,
                activity_constDateValue TIMESTAMP,
                element_id BIGINT,
                constraintDateType_id BIGINT,
                place_id BIGINT,
                CONSTRAINT activity_pk PRIMARY KEY (activity_id)
);


CREATE TABLE projectDefinition.unit (
                unit_id IDENTITY NOT NULL,
                project_id BIGINT NOT NULL,
                unit_code VARCHAR(255),
                unit_name VARCHAR(255),
                CONSTRAINT unit_pk PRIMARY KEY (unit_id)
);


CREATE TABLE projectDefinition.humanResource (
                humanResource_id IDENTITY NOT NULL,
                project_id BIGINT NOT NULL,
                humanResource_profileCode VARCHAR(255),
                humanResource_profileName VARCHAR(255),
                humanResource_resInit VARCHAR(255),
                humanResource_capacity INTEGER,
                humanResource_stdRate DECIMAL,
                humanResource_ovtRate DECIMAL,
                humanResource_useCost DECIMAL,
                humanResource_isCritical BOOLEAN,
                skill_id BIGINT,
                allocationMode_id BIGINT,
                targetGroup_id BIGINT,
                unit_id BIGINT,
				place_id BIGINT,
                CONSTRAINT humanResource_pk PRIMARY KEY (humanResource_id)
);


CREATE TABLE projectDefinition.humanResourceNeeded (
                activity_id BIGINT NOT NULL,
                humanResource_id BIGINT NOT NULL,
                responsibility_id BIGINT,
                humanResourceNeeded_wrklAssigned DECIMAL,
                humanResourceNeeded_resCapacity BIGINT,
                CONSTRAINT humanResourceNeeded_pk PRIMARY KEY (activity_id, humanResource_id)
);


CREATE TABLE projectDefinition.document (
                document_id IDENTITY NOT NULL,
                project_id BIGINT NOT NULL,
                document_code VARCHAR(255),
                document_label VARCHAR(255),
                recordCarrier_id BIGINT,
                frequency_id BIGINT,
                humanResource_idResponsible BIGINT,
                targetGroup_id BIGINT,
                humanResource_idDispatcher BIGINT,
                CONSTRAINT document_pk PRIMARY KEY (document_id)
);


CREATE TABLE projectDefinition.risk (
                risk_id IDENTITY NOT NULL,
                project_id BIGINT NOT NULL,
                risk_label VARCHAR(255) NOT NULL,
                risk_description CLOB,
                risk_event VARCHAR(255),
                risk_probability INTEGER,
                risk_impact INTEGER,
                risk_detectionDifficulty INTEGER,
                risk_outcome CLOB,
                risk_financial DECIMAL,
                risk_provision DECIMAL,
                risk_modality CLOB,
                risk_horizon VARCHAR(255),
                element_id BIGINT,
                riskStrategy_id BIGINT,
                humanResource_idResourceDetection BIGINT,
                humanResource_idResourceResponsible BIGINT,
                riskNature_id BIGINT,
                CONSTRAINT risk_pk PRIMARY KEY (risk_id)
);


CREATE TABLE projectDefinition.requirement (
                requirement_id IDENTITY NOT NULL,
                project_id BIGINT NOT NULL,
                requirement_code VARCHAR(255),
                requirement_label VARCHAR(255),
                requirement_acceptanceCriteria CLOB,
                level_idLevelOfCriticity BIGINT,
                level_idLevelOfHardness BIGINT,
                flexibility_id BIGINT,
                humanResource_idRequirementOwner BIGINT,
                humanResource_idRequirementResponsible BIGINT,
                trackingMethod_id BIGINT,
                element_id BIGINT,
                CONSTRAINT requirement_pk PRIMARY KEY (requirement_id)
);


CREATE TABLE projectDefinition.materialResource (
                materialResource_id IDENTITY NOT NULL,
                project_id BIGINT NOT NULL,
                materialResource_equipCode VARCHAR(255),
                materialResource_equipDescription VARCHAR(255),
                materialResource_equipLabel VARCHAR(255),
                materialResource_resInitial VARCHAR(255),
                materialResource_resStdRate DECIMAL,
                materialResource_resOvtRate DECIMAL,
                materialResource_resUseCost DECIMAL,
                materialResource_isCritical BOOLEAN,
                materialResource_resCapacitiy INTEGER,
                place_id BIGINT,
                unit_id BIGINT,
                allocationMode_id BIGINT,
                resourceType_id BIGINT,
                CONSTRAINT materialResource_pk PRIMARY KEY (materialResource_id)
);


CREATE TABLE projectDefinition.materialResourceNeededActiviy (
                activity_id BIGINT NOT NULL,
                materialResource_id BIGINT NOT NULL,
                materialResourceNeededActiviy_quantity BIGINT,
                CONSTRAINT materialResourceNeededActiviy_pk PRIMARY KEY (activity_id, materialResource_id)
);


CREATE TABLE projectDefinition.state (
                state_id IDENTITY NOT NULL,
                project_id BIGINT NOT NULL,
                state_label VARCHAR(255) NOT NULL,
                state_isMilestone BOOLEAN,
                element_id BIGINT,
                activity_idActivityPredecessorToState BIGINT,
                CONSTRAINT state_pk PRIMARY KEY (state_id)
);


CREATE TABLE projectDefinition.statePredecessorToActivity (
                state_id BIGINT NOT NULL,
                activity_id BIGINT NOT NULL,
                CONSTRAINT statePredecessorToActivity_pk PRIMARY KEY (state_id, activity_id)
);


CREATE TABLE projectDefinition.contributor (
                project_id BIGINT NOT NULL,
                user_id BIGINT NOT NULL,
                CONSTRAINT contributor_pk PRIMARY KEY (project_id, user_id)
);


ALTER TABLE projectDefinition.activity ADD CONSTRAINT constraintDateType_activity_fk
FOREIGN KEY (constraintDateType_id)
REFERENCES projectDefinition.constraintDateType (constraintDateType_id)
ON DELETE SET NULL
ON UPDATE CASCADE;

ALTER TABLE projectDefinition.meeting ADD CONSTRAINT meetingMedia_meeting_fk
FOREIGN KEY (meetingMedia_id)
REFERENCES projectDefinition.meetingMedia (meetingMedia_id)
ON DELETE NO ACTION
ON UPDATE CASCADE;

ALTER TABLE projectDefinition.humanResourceNeeded ADD CONSTRAINT responsibility_humanResourceNeeded_fk
FOREIGN KEY (responsibility_id)
REFERENCES projectDefinition.responsibility (responsibility_id)
ON DELETE SET NULL
ON UPDATE CASCADE;

ALTER TABLE projectDefinition.risk ADD CONSTRAINT riskNature_risk_fk
FOREIGN KEY (riskNature_id)
REFERENCES projectDefinition.riskNature (riskNature_id)
ON DELETE SET NULL
ON UPDATE CASCADE;

ALTER TABLE projectDefinition.document ADD CONSTRAINT frequency_document_fk
FOREIGN KEY (frequency_id)
REFERENCES projectDefinition.frequency (frequency_id)
ON DELETE SET NULL
ON UPDATE CASCADE;

ALTER TABLE projectDefinition.meeting ADD CONSTRAINT frequency_meeting_fk
FOREIGN KEY (frequency_id)
REFERENCES projectDefinition.frequency (frequency_id)
ON DELETE SET NULL
ON UPDATE CASCADE;

ALTER TABLE projectDefinition.document ADD CONSTRAINT recordCarrier_document_fk
FOREIGN KEY (recordCarrier_id)
REFERENCES projectDefinition.recordCarrier (recordCarrier_id)
ON DELETE SET NULL
ON UPDATE CASCADE;

ALTER TABLE projectDefinition.humanResource ADD CONSTRAINT skill_humanResource_fk
FOREIGN KEY (skill_id)
REFERENCES projectDefinition.skill (skill_id)
ON DELETE SET NULL
ON UPDATE CASCADE;

ALTER TABLE projectDefinition.materialResource ADD CONSTRAINT allocationMode_materialResource_fk
FOREIGN KEY (allocationMode_id)
REFERENCES projectDefinition.allocationMode (allocationMode_id)
ON DELETE SET NULL
ON UPDATE CASCADE;

ALTER TABLE projectDefinition.humanResource ADD CONSTRAINT allocationMode_humanResource_fk
FOREIGN KEY (allocationMode_id)
REFERENCES projectDefinition.allocationMode (allocationMode_id)
ON DELETE SET NULL
ON UPDATE CASCADE;

ALTER TABLE projectDefinition.materialResource ADD CONSTRAINT resourceType_materialResource_fk
FOREIGN KEY (resourceType_id)
REFERENCES projectDefinition.resourceType (resourceType_id)
ON DELETE SET NULL
ON UPDATE CASCADE;

ALTER TABLE projectDefinition.risk ADD CONSTRAINT riskStrategy_risk_fk
FOREIGN KEY (riskStrategy_id)
REFERENCES projectDefinition.riskStrategy (riskStrategy_id)
ON DELETE SET NULL
ON UPDATE CASCADE;

ALTER TABLE projectDefinition.requirement ADD CONSTRAINT trackingMethod_requirement_fk
FOREIGN KEY (trackingMethod_id)
REFERENCES projectDefinition.trackingMethod (trackingMethod_id)
ON DELETE SET NULL
ON UPDATE CASCADE;

ALTER TABLE projectDefinition.requirement ADD CONSTRAINT flexibility_requirement_fk
FOREIGN KEY (flexibility_id)
REFERENCES projectDefinition.flexibility (flexibility_id)
ON DELETE SET NULL
ON UPDATE CASCADE;

ALTER TABLE projectDefinition.requirement ADD CONSTRAINT level_requirement_fk
FOREIGN KEY (level_idLevelOfCriticity)
REFERENCES projectDefinition.level (level_id)
ON DELETE SET NULL
ON UPDATE CASCADE;

ALTER TABLE projectDefinition.requirement ADD CONSTRAINT level_requirement_fk1
FOREIGN KEY (level_idLevelOfHardness)
REFERENCES projectDefinition.level (level_id)
ON DELETE SET NULL
ON UPDATE CASCADE;

ALTER TABLE projectDefinition.project ADD CONSTRAINT user_project_fk
FOREIGN KEY (user_projectManagerId)
REFERENCES projectDefinition.user (user_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE projectDefinition.contributor ADD CONSTRAINT user_contributor_fk
FOREIGN KEY (user_id)
REFERENCES projectDefinition.user (user_id)
ON DELETE CASCADE
ON UPDATE CASCADE;

ALTER TABLE projectDefinition.user ADD CONSTRAINT project_user_fk
FOREIGN KEY (project_idLastProject)
REFERENCES projectDefinition.project (project_id)
ON DELETE SET NULL
ON UPDATE CASCADE;

ALTER TABLE projectDefinition.contributor ADD CONSTRAINT project_contributor_fk
FOREIGN KEY (project_id)
REFERENCES projectDefinition.project (project_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE projectDefinition.state ADD CONSTRAINT project_state_fk
FOREIGN KEY (project_id)
REFERENCES projectDefinition.project (project_id)
ON DELETE CASCADE
ON UPDATE CASCADE;

ALTER TABLE projectDefinition.materialResource ADD CONSTRAINT project_materialResource_fk
FOREIGN KEY (project_id)
REFERENCES projectDefinition.project (project_id)
ON DELETE CASCADE
ON UPDATE CASCADE;

ALTER TABLE projectDefinition.unit ADD CONSTRAINT project_unit_fk
FOREIGN KEY (project_id)
REFERENCES projectDefinition.project (project_id)
ON DELETE CASCADE
ON UPDATE CASCADE;

ALTER TABLE projectDefinition.place ADD CONSTRAINT project_place_fk
FOREIGN KEY (project_id)
REFERENCES projectDefinition.project (project_id)
ON DELETE CASCADE
ON UPDATE CASCADE;

ALTER TABLE projectDefinition.element ADD CONSTRAINT project_element_fk
FOREIGN KEY (project_id)
REFERENCES projectDefinition.project (project_id)
ON DELETE CASCADE
ON UPDATE CASCADE;

ALTER TABLE projectDefinition.risk ADD CONSTRAINT project_risk_fk
FOREIGN KEY (project_id)
REFERENCES projectDefinition.project (project_id)
ON DELETE CASCADE
ON UPDATE CASCADE;

ALTER TABLE projectDefinition.meeting ADD CONSTRAINT project_meeting_fk
FOREIGN KEY (project_id)
REFERENCES projectDefinition.project (project_id)
ON DELETE CASCADE
ON UPDATE CASCADE;

ALTER TABLE projectDefinition.requirement ADD CONSTRAINT project_requirement_fk
FOREIGN KEY (project_id)
REFERENCES projectDefinition.project (project_id)
ON DELETE CASCADE
ON UPDATE CASCADE;

ALTER TABLE projectDefinition.activity ADD CONSTRAINT project_activity_fk
FOREIGN KEY (project_id)
REFERENCES projectDefinition.project (project_id)
ON DELETE CASCADE
ON UPDATE CASCADE;

ALTER TABLE projectDefinition.targetGroup ADD CONSTRAINT project_targetGroup_fk
FOREIGN KEY (project_id)
REFERENCES projectDefinition.project (project_id)
ON DELETE CASCADE
ON UPDATE CASCADE;

ALTER TABLE projectDefinition.document ADD CONSTRAINT project_document_fk
FOREIGN KEY (project_id)
REFERENCES projectDefinition.project (project_id)
ON DELETE CASCADE
ON UPDATE CASCADE;

ALTER TABLE projectDefinition.humanResource ADD CONSTRAINT project_humanResource_fk
FOREIGN KEY (project_id)
REFERENCES projectDefinition.project (project_id)
ON DELETE CASCADE
ON UPDATE CASCADE;

ALTER TABLE projectDefinition.document ADD CONSTRAINT targetGroup_document_fk
FOREIGN KEY (targetGroup_id, project_id)
REFERENCES projectDefinition.targetGroup (targetGroup_id, project_id)
ON DELETE NO ACTION
ON UPDATE CASCADE;

ALTER TABLE projectDefinition.humanResource ADD CONSTRAINT targetGroup_humanResource_fk
FOREIGN KEY (targetGroup_id)
REFERENCES projectDefinition.targetGroup (targetGroup_id)
ON DELETE NO ACTION
ON UPDATE CASCADE;

ALTER TABLE projectDefinition.humanResource ADD CONSTRAINT place_humanResource_fk
FOREIGN KEY (place_id)
REFERENCES projectDefinition.place (place_id)
ON DELETE NO ACTION
ON UPDATE CASCADE;

ALTER TABLE projectDefinition.element ADD CONSTRAINT element_element_fk
FOREIGN KEY (Parent_element_id)
REFERENCES projectDefinition.element (element_id)
ON DELETE NO ACTION
ON UPDATE CASCADE;

ALTER TABLE projectDefinition.requirement ADD CONSTRAINT element_requirement_fk
FOREIGN KEY (element_id)
REFERENCES projectDefinition.element (element_id)
ON DELETE NO ACTION
ON UPDATE CASCADE;

ALTER TABLE projectDefinition.risk ADD CONSTRAINT element_risk_fk
FOREIGN KEY (element_id)
REFERENCES projectDefinition.element (element_id)
ON DELETE CASCADE
ON UPDATE CASCADE;

ALTER TABLE projectDefinition.activity ADD CONSTRAINT element_activity_fk
FOREIGN KEY (element_id)
REFERENCES projectDefinition.element (element_id)
ON DELETE NO ACTION
ON UPDATE CASCADE;

ALTER TABLE projectDefinition.state ADD CONSTRAINT element_state_fk
FOREIGN KEY (element_id)
REFERENCES projectDefinition.element (element_id)
ON DELETE NO ACTION
ON UPDATE CASCADE;

ALTER TABLE projectDefinition.activity ADD CONSTRAINT place_activity_fk
FOREIGN KEY (place_id)
REFERENCES projectDefinition.place (place_id)
ON DELETE NO ACTION
ON UPDATE CASCADE;

ALTER TABLE projectDefinition.materialResource ADD CONSTRAINT place_materialResource_fk
FOREIGN KEY (place_id)
REFERENCES projectDefinition.place (place_id)
ON DELETE NO ACTION
ON UPDATE CASCADE;

ALTER TABLE projectDefinition.meeting ADD CONSTRAINT place_meeting_fk
FOREIGN KEY (place_id)
REFERENCES projectDefinition.place (place_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE projectDefinition.statePredecessorToActivity ADD CONSTRAINT activity_statePredecessorToActivity_fk
FOREIGN KEY (activity_id)
REFERENCES projectDefinition.activity (activity_id)
ON DELETE NO ACTION
ON UPDATE CASCADE;

ALTER TABLE projectDefinition.materialResourceNeededActiviy ADD CONSTRAINT activity_materialResourceNeededActiviy_fk
FOREIGN KEY (activity_id)
REFERENCES projectDefinition.activity (activity_id)
ON DELETE CASCADE
ON UPDATE CASCADE;

ALTER TABLE projectDefinition.state ADD CONSTRAINT activity_state_fk
FOREIGN KEY (activity_idActivityPredecessorToState)
REFERENCES projectDefinition.activity (activity_id)
ON DELETE NO ACTION
ON UPDATE CASCADE;

ALTER TABLE projectDefinition.humanResourceNeeded ADD CONSTRAINT activity_humanResourceNeeded_fk
FOREIGN KEY (activity_id)
REFERENCES projectDefinition.activity (activity_id)
ON DELETE CASCADE
ON UPDATE CASCADE;

ALTER TABLE projectDefinition.materialResource ADD CONSTRAINT unit_materialResource_fk
FOREIGN KEY (unit_id)
REFERENCES projectDefinition.unit (unit_id)
ON DELETE NO ACTION
ON UPDATE CASCADE;

ALTER TABLE projectDefinition.humanResource ADD CONSTRAINT unit_humanResource_fk
FOREIGN KEY (unit_id)
REFERENCES projectDefinition.unit (unit_id)
ON DELETE NO ACTION
ON UPDATE CASCADE;

ALTER TABLE projectDefinition.requirement ADD CONSTRAINT humanResource_requirement_fk
FOREIGN KEY (humanResource_idRequirementOwner)
REFERENCES projectDefinition.humanResource (humanResource_id)
ON DELETE NO ACTION
ON UPDATE CASCADE;

ALTER TABLE projectDefinition.requirement ADD CONSTRAINT humanResource_requirement_fk1
FOREIGN KEY (humanResource_idRequirementResponsible)
REFERENCES projectDefinition.humanResource (humanResource_id)
ON DELETE NO ACTION
ON UPDATE CASCADE;

ALTER TABLE projectDefinition.risk ADD CONSTRAINT humanResource_risk_fk
FOREIGN KEY (humanResource_idResourceDetection)
REFERENCES projectDefinition.humanResource (humanResource_id)
ON DELETE NO ACTION
ON UPDATE CASCADE;

ALTER TABLE projectDefinition.risk ADD CONSTRAINT humanResource_risk_fk1
FOREIGN KEY (humanResource_idResourceResponsible)
REFERENCES projectDefinition.humanResource (humanResource_id)
ON DELETE NO ACTION
ON UPDATE CASCADE;

ALTER TABLE projectDefinition.document ADD CONSTRAINT humanResource_document_fk
FOREIGN KEY (humanResource_idResponsible)
REFERENCES projectDefinition.humanResource (humanResource_id)
ON DELETE NO ACTION
ON UPDATE CASCADE;

ALTER TABLE projectDefinition.document ADD CONSTRAINT humanResource_document_fk1
FOREIGN KEY (humanResource_idDispatcher)
REFERENCES projectDefinition.humanResource (humanResource_id)
ON DELETE NO ACTION
ON UPDATE CASCADE;

ALTER TABLE projectDefinition.humanResourceNeeded ADD CONSTRAINT humanResource_humanResourceNeeded_fk
FOREIGN KEY (humanResource_id)
REFERENCES projectDefinition.humanResource (humanResource_id)
ON DELETE NO ACTION
ON UPDATE CASCADE;

ALTER TABLE projectDefinition.materialResourceNeededActiviy ADD CONSTRAINT materialResource_materialResourceNeededActiviy_fk
FOREIGN KEY (materialResource_id)
REFERENCES projectDefinition.materialResource (materialResource_id)
ON DELETE NO ACTION
ON UPDATE CASCADE;

ALTER TABLE projectDefinition.statePredecessorToActivity ADD CONSTRAINT state_statePredecessorToActivity_fk
FOREIGN KEY (state_id)
REFERENCES projectDefinition.state (state_id)
ON DELETE NO ACTION
ON UPDATE CASCADE;
